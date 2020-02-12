package com.glsx.gecc.che300.service;

import com.glsx.gecc.che300.req.*;
import com.glsx.gecc.che300.resp.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "che300Service")
public interface IChe300Service {

    @GetMapping("/api/v1/getAllCity")
    public CityListResp getAllCity(CityListReq req);

    @GetMapping("/api/v1/commonEval")
    public String commonEval();

    @GetMapping("/api/v1/getCarBrandList")
    public CarBrandListResp getCarBrandList(CarBrandListReq req);

    @GetMapping("/api/v1/getCarSeriesList")
    public CarSeriesListResp getCarSeriesList(CarSeriesListReq req);

    @GetMapping("/api/v1/getCarModelList")
    public CarModelListResp getCarModelList(CarModelListReq req);

    @GetMapping("/api/v1/getSeriesInfo")
    public SeriesInfoResp getSeriesInfo(SeriesInfoReq req);

    @GetMapping("/api/v1/getCarModelInfo")
    public CarModelInfoResp getCarModelInfo(CarModelInfoReq req);

    @GetMapping("/api/v1/getModelParameters")
    public ModelParametersResp getModelParameters(ModelParametersReq req);

    @GetMapping("/api/v1/getUpdatedModelParamsInTimeRange")
    public UpdatedModelParamsInTimeRangeResp getUpdatedModelParamsInTimeRange(UpdatedModelParamsInTimeRangeReq req);

    @GetMapping("/api/v1/getUsedCarPrice")
    public UsedCarPriceResp getUsedCarPrice(UsedCarPriceReq req);

}
