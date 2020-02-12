package com.glsx.gecc;//package com.hflw.vasp.admin;

import com.alibaba.fastjson.JSON;
import com.glsx.gecc.che300.req.*;
import com.glsx.gecc.che300.resp.*;
import com.glsx.gecc.che300.service.IChe300Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Che300ApplicationTests {

    @Autowired
    private IChe300Service che300Service;

    @Test
    public void getAllCity() throws Exception {
        CityListReq req = new CityListReq();
        CityListResp resp = che300Service.getAllCity(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getCarBrandList() throws Exception {
        CarBrandListReq req = new CarBrandListReq();
        CarBrandListResp resp = che300Service.getCarBrandList(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getCarSeriesList() throws Exception {
        CarSeriesListReq req = new CarSeriesListReq();
        req.setBrandId(35);
        CarSeriesListResp resp = che300Service.getCarSeriesList(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getCarModelList() throws Exception {
        CarModelListReq req = new CarModelListReq();
        req.setSeriesId(408);
        CarModelListResp resp = che300Service.getCarModelList(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getSeriesInfo() throws Exception {
        SeriesInfoReq req = new SeriesInfoReq();
        req.setSeriesId(5);
        SeriesInfoResp resp = che300Service.getSeriesInfo(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getCarModelInfo() throws Exception {
        CarModelInfoReq req = new CarModelInfoReq();
        req.setModelId(1351700);
        CarModelInfoResp resp = che300Service.getCarModelInfo(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getModelParameters() throws Exception {
        ModelParametersReq req = new ModelParametersReq();
        req.setModelId(1234745);
        req.setVersion(2);
//        req.setKeyType("en");
        ModelParametersResp resp = che300Service.getModelParameters(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getUpdatedModelParamsInTimeRange() throws Exception {
        UpdatedModelParamsInTimeRangeReq req = new UpdatedModelParamsInTimeRangeReq();
        req.setFromTime("2019-12-02");
        UpdatedModelParamsInTimeRangeResp resp = che300Service.getUpdatedModelParamsInTimeRange(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getUsedCarPrice() throws Exception {
        UsedCarPriceReq req = new UsedCarPriceReq();
        req.setModelId(5997);
        req.setZone("50");
        req.setMile(3.2);
        req.setRegDate("2015-11");
        UsedCarPriceResp resp = che300Service.getUsedCarPrice(req);
        System.out.println(JSON.toJSONString(resp));
    }

}