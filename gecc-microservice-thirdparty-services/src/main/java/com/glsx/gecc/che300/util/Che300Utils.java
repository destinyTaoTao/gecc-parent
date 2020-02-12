package com.glsx.gecc.che300.util;

import com.alibaba.fastjson.JSON;
import com.glsx.gecc.che300.Che300Config;
import com.glsx.gecc.che300.req.*;
import com.glsx.vasp.exception.ServiceException;
import com.glsx.vasp.utils.HttpUtils;
import com.glsx.vasp.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class Che300Utils {

    @Resource
    private Che300Config config;

    /**
     * 调用车300服务
     */
    public <T> T access(String url, Object req, Class<T> clazz) throws ServiceException {
        AbstractChe300Request param = (AbstractChe300Request) req;
        // 1. 补全请求数据
        complementedRequestData(param);
        // 2. 校验请求数据
        verifyRequestData(param);
        // 3. 网络请求,获取结果
        return realCall(url, param, clazz);
    }

    /**
     * 补全请求实体—— 补全通用的实体属性,比如appkey属性及sign属性。
     * 也可以通过 instanceof,针对特定请求实体进行补全操作。
     */
    private void complementedRequestData(AbstractChe300Request req) {
        req.setToken(config.getToken());
    }

    /**
     * 校验请求实体的通用属性,比如appkey属性及sign属性。
     * 也可以通过 instanceof,针对特定请求实体进行校验操作。
     */
    private void verifyRequestData(AbstractChe300Request req) {
        if (StringUtils.isNullOrEmpty(req.getToken())) {
            throw ServiceException.create("缺少必填参数");
        }
        // 针对 车辆品牌 的请求数据进行校验
        if (req instanceof CarBrandListReq) {
            CarBrandListReq verifyReq = (CarBrandListReq) req;
            checkCarBrandListRequestData(verifyReq);
        }
        // 针对 车辆系别 的请求数据进行校验
        if (req instanceof CarSeriesListReq) {
            CarSeriesListReq verifyReq = (CarSeriesListReq) req;
            checkCarSeriesListRequestData(verifyReq);
        }
        // 针对 车辆型号 的请求数据进行校验
        if (req instanceof CarModelListReq) {
            CarModelListReq verifyReq = (CarModelListReq) req;
            checkCarModelListRequestData(verifyReq);
        }
        // 针对 车系详情 的请求数据进行校验
        if (req instanceof SeriesInfoReq) {
            SeriesInfoReq verifyReq = (SeriesInfoReq) req;
            checkSeriesInfoRequestData(verifyReq);
        }
        // 针对 车型详情 的请求数据进行校验
        if (req instanceof CarModelInfoReq) {
            CarModelInfoReq verifyReq = (CarModelInfoReq) req;
            checkCarModelInfoRequestData(verifyReq);
        }
        // 针对 车型参数详情 的请求数据进行校验
        if (req instanceof ModelParametersReq) {
            ModelParametersReq verifyReq = (ModelParametersReq) req;
            checkModelParametersRequestData(verifyReq);
        }
        // 针对 车型参数区间更新 的请求数据进行校验
        if (req instanceof UpdatedModelParamsInTimeRangeReq) {
            UpdatedModelParamsInTimeRangeReq verifyReq = (UpdatedModelParamsInTimeRangeReq) req;
            checkUpdatedModelParamsInTimeRangeRequestData(verifyReq);
        }
        // 针对 车辆估价 的请求数据进行校验
        if (req instanceof UsedCarPriceReq) {
            UsedCarPriceReq verifyReq = (UsedCarPriceReq) req;
            checkUsedCarPriceRequestData(verifyReq);
        }
    }

    /**
     * 车辆估值参数校验
     *
     * @param verifyReq
     */
    private void checkUsedCarPriceRequestData(UsedCarPriceReq verifyReq) {
        if (Objects.isNull(verifyReq.getModelId())
                || StringUtils.isNullOrEmpty(verifyReq.getZone())
                || StringUtils.isNullOrEmpty(verifyReq.getRegDate())
                || Objects.isNull(verifyReq.getMile()))
            throw ServiceException.create("缺少必填参数");
    }

    /**
     * 车辆型号参数区间更新参数校验
     *
     * @param verifyReq
     */
    private void checkUpdatedModelParamsInTimeRangeRequestData(UpdatedModelParamsInTimeRangeReq verifyReq) {
        if (StringUtils.isNullOrEmpty(verifyReq.getFromTime())) throw ServiceException.create("缺少必填参数");
    }

    /**
     * 获取车辆型号参数校验
     *
     * @param verifyReq
     */
    private void checkModelParametersRequestData(ModelParametersReq verifyReq) {
        if (Objects.isNull(verifyReq.getModelId()) || Objects.isNull(verifyReq.getVersion()))
            throw ServiceException.create("缺少必填参数");
    }

    /**
     * 获取车辆型号详情参数校验
     *
     * @param verifyReq
     */
    private void checkCarModelInfoRequestData(CarModelInfoReq verifyReq) {
        if (Objects.isNull(verifyReq.getModelId())) throw ServiceException.create("缺少必填参数");
    }

    /**
     * 获取车辆系别详情参数校验
     *
     * @param verifyReq
     */
    private void checkSeriesInfoRequestData(SeriesInfoReq verifyReq) {
        if (Objects.isNull(verifyReq.getSeriesId())) throw ServiceException.create("缺少必填参数");
    }

    /**
     * 获取车辆型号列表参数校验
     *
     * @param verifyReq
     */
    private void checkCarModelListRequestData(CarModelListReq verifyReq) {
        if (Objects.isNull(verifyReq.getSeriesId())) throw ServiceException.create("缺少必填参数");
    }

    /**
     * 获取车辆系别列表参数校验
     *
     * @param verifyReq
     */
    private void checkCarSeriesListRequestData(CarSeriesListReq verifyReq) {
        if (Objects.isNull(verifyReq.getBrandId())) throw ServiceException.create("缺少必填参数");
    }

    /**
     * 获取车辆品牌列表参数校验
     *
     * @param verifyReq
     */
    private void checkCarBrandListRequestData(CarBrandListReq verifyReq) {

    }

    /**
     * 真正调用网络请求方法
     *
     * @param url
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T realCall(String url, Object param, Class<T> clazz) throws ServiceException {
        log.info("【车300服务】http请求信息—— url[{}] param[{}]", url, JSON.toJSONString(param, true));
        HttpUtils httpUtils = new HttpUtils();
        String result = null;
        try {
            Map map = JSON.parseObject(JSON.toJSONString(param), Map.class);

            Map<String, String> paramsMap = new HashMap<>();
            map.forEach((key, value) -> {
                if (value != null) paramsMap.put(String.valueOf(key), String.valueOf(value));
            });
            result = httpUtils.get(url, paramsMap);
        } catch (Exception e) {
            log.error("【车300服务】http请求调用发生错误——{}", e.toString());
            throw ServiceException.create("【车300服务】http请求调用发生错误——" + e.toString());
        }
        log.info("【车300服务】http响应信息—— result[{}]", result);
        return JSON.parseObject(result, clazz);
    }

}
