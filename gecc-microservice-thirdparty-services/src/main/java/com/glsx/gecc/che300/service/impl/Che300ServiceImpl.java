package com.glsx.gecc.che300.service.impl;

import com.glsx.gecc.che300.Che300Config;
import com.glsx.gecc.che300.req.*;
import com.glsx.gecc.che300.resp.*;
import com.glsx.gecc.che300.service.IChe300Service;
import com.glsx.gecc.che300.util.Che300Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class Che300ServiceImpl implements IChe300Service {

    @Resource
    private Che300Utils utils;

    @Resource
    private Che300Config config;

    @Override
    public CityListResp getAllCity(CityListReq req) {
        CityListResp resp = utils.access(config.getAllCityUrl(), req, CityListResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public String commonEval() {
        return null;
    }

    @Override
    public CarBrandListResp getCarBrandList(CarBrandListReq req) {
        CarBrandListResp resp = utils.access(config.getCarBrandListUrl(), req, CarBrandListResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public CarSeriesListResp getCarSeriesList(CarSeriesListReq req) {
        CarSeriesListResp resp = utils.access(config.getCarSeriesListUrl(), req, CarSeriesListResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public CarModelListResp getCarModelList(CarModelListReq req) {
        CarModelListResp resp = utils.access(config.getCarModelListUrl(), req, CarModelListResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public SeriesInfoResp getSeriesInfo(SeriesInfoReq req) {
        SeriesInfoResp resp = utils.access(config.getSeriesInfoUrl(), req, SeriesInfoResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public CarModelInfoResp getCarModelInfo(CarModelInfoReq req) {
        CarModelInfoResp resp = utils.access(config.getCarModelInfoUrl(), req, CarModelInfoResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public ModelParametersResp getModelParameters(ModelParametersReq req) {
        ModelParametersResp resp = utils.access(config.getModelParametersUrl(), req, ModelParametersResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public UpdatedModelParamsInTimeRangeResp getUpdatedModelParamsInTimeRange(UpdatedModelParamsInTimeRangeReq req) {
        UpdatedModelParamsInTimeRangeResp resp = utils.access(config.getUpdatedModelParamsInTimeRangeUrl(), req, UpdatedModelParamsInTimeRangeResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

    @Override
    public UsedCarPriceResp getUsedCarPrice(UsedCarPriceReq req) {
        UsedCarPriceResp resp = utils.access(config.getUsedCarPriceUrl(), req, UsedCarPriceResp.class);

        if (resp == null || resp.getStatus() != 1) return null;
        return resp;
    }

}
