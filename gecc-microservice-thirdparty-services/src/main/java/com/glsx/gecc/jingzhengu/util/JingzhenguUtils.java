package com.glsx.gecc.jingzhengu.util;

import com.alibaba.fastjson.JSON;
import com.glsx.gecc.jingzhengu.JingzhenguConfig;
import com.glsx.gecc.jingzhengu.req.AbstractJingzhenguRequest;
import com.glsx.gecc.jingzhengu.req.CommonJingzhenguRequest;
import com.glsx.vasp.exception.ServiceException;
import com.glsx.vasp.utils.DateUtils;
import com.glsx.vasp.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
public class JingzhenguUtils {

    @Resource
    private JingzhenguConfig config;


    /**
     * 调用精真估-车型接口
     */
    public <T> T accessNvapiUrl(String subRoute, Object req, Class<T> clazz) throws ServiceException {
        String url = config.getUrl() + subRoute;

        return access(url, req, clazz);
    }

    /**
     * 调用精真估-估值接口
     */
    public <T> T accessGuzhiUrl(String subRoute, Object req, Class<T> clazz) throws ServiceException {
        String url = config.getGuzhiUrl() + subRoute;

        return access(url, req, clazz);
    }

    /**
     * 调用精真估
     */
    private <T> T access(String url, Object req, Class<T> clazz) throws ServiceException {

        String callMethodName = Thread.currentThread().getStackTrace()[3].getMethodName();

        AbstractJingzhenguRequest paramReq = (AbstractJingzhenguRequest) req;

        // 1. 校验请求数据
        verifyRequestData(paramReq);

        // 2. 构建请求参数body
        String jsonBody = getRequestBody(paramReq);

        // 3. 补全请求数据
        CommonJingzhenguRequest param = complementedRequestData(jsonBody);

        // 4. 网络请求,获取结果
        return realCall(url + callMethodName + "?json=" + JSON.toJSONString(param), param, clazz);
    }

    /**
     * 把具体接口参数转成json字符串
     *
     * @param req
     * @return
     */
    private String getRequestBody(AbstractJingzhenguRequest req) {
        String body = JSON.toJSONString(req);
        log.info("【精真估】原始参数：[{}]", body);
        return body;
    }

    /**
     * 封装最终请求参数
     *
     * @param jsonBody
     * @return
     */
    private CommonJingzhenguRequest complementedRequestData(String jsonBody) throws ServiceException {
        CommonJingzhenguRequest param = new CommonJingzhenguRequest();

        String partnerId = config.getPartnerId();
        String sequenceId = DateUtils.formatNormal(new Date());

        param.setPartnerId(partnerId);
        param.setSequenceId(sequenceId);

        //消息体，密文，加密规则 ToBase64(3DES(body 明文) body 明文为 json 格式，可作为单独 json 解析，加密后放入 body 节点中
        String body = "";
        try {
            body = EncryptUtil.BASE64Encrypt(EncryptUtil.DES3Encrypt(config.getKey(), jsonBody));
        } catch (Exception e) {
            throw ServiceException.create("【精真估】加密数据发生错误——" + e.toString());
        }
        log.info("【精真估】加密参数：[{}]", body);
        //消息签名，签名规则 ToBase64(Md5(sequenceId + partnerId + operate +body密文+key))
        String sign = EncryptUtil.BASE64Encrypt(EncryptUtil.MD5(sequenceId + partnerId + body + config.getKey()));
        log.info("【精真估】参数签名：[{}]", sign);

        param.setBody(body);
        param.setSign(sign);

        return param;
    }

    /**
     * 解密返回数据
     *
     * @param encryptBody
     * @return
     */
    public String getDecryptData(String encryptBody) {
        String data = EncryptUtil.DES3Decrypt(EncryptUtil.BASE64Decrypt(encryptBody), config.getKey());
        return data;
    }

    /**
     * 校验请求实体的通用属性,比如appkey属性及sign属性。
     * 也可以通过 instanceof,针对特定请求实体进行校验操作。
     */
    private void verifyRequestData(AbstractJingzhenguRequest req) {

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
        log.info("【精真估】http请求信息—— url[{}] param[{}]", url, JSON.toJSONString(param, true));
        HttpUtils httpUtils = new HttpUtils();
        String result = null;
        try {
            Map map = JSON.parseObject(JSON.toJSONString(param), Map.class);
            result = httpUtils.post(url, map);
        } catch (Exception e) {
            log.error("【精真估】http请求调用发生错误——{}", e.toString());
            throw ServiceException.create("【精真估】http请求调用发生错误——" + e.toString());
        }
        log.info("【精真估】http响应信息—— result[{}]", result);
        return JSON.parseObject(result, clazz);
    }

}
