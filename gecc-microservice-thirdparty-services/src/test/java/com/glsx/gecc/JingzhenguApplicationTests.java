package com.glsx.gecc;

import com.alibaba.fastjson.JSON;
import com.glsx.gecc.jingzhengu.req.*;
import com.glsx.gecc.jingzhengu.resp.*;
import com.glsx.gecc.jingzhengu.service.JingzhenguService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JingzhenguApplicationTests {

    @Autowired
    private JingzhenguService jingzhenguService;

    @Test
    public void getProvinceListInfo() throws Exception {
        GetProvinceListInfoReq req = new GetProvinceListInfoReq();
        GetProvinceListInfoResp resp = jingzhenguService.getProvinceListInfo(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getProvCityListInfo() throws Exception {
        GetProvCityListInfoReq req = new GetProvCityListInfoReq();
        req.setProvinceId(12345);
        GetProvCityListInfoResp resp = jingzhenguService.getProvCityListInfo(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getMakeByAll() throws Exception {
        GetMakeByAllReq req = new GetMakeByAllReq();

        GetMakeByAllResp resp = jingzhenguService.getMakeByAll(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getSubModelByMakeId() throws Exception {
        GetSubModelByMakeIdReq req = new GetSubModelByMakeIdReq();

        GetSubModelByMakeIdResp resp = jingzhenguService.getSubModelByMakeId(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getModels() throws Exception {
        GetModelsReq req = new GetModelsReq();

        GetModelsResp resp = jingzhenguService.getModels(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getStyleByModelId() throws Exception {
        GetStyleByModelIdReq req = new GetStyleByModelIdReq();

        GetStyleByModelIdResp resp = jingzhenguService.getStyleByModelId(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getStyles() throws Exception {
        GetStylesReq req = new GetStylesReq();

        GetStylesResp resp = jingzhenguService.getStyles(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getStyleColorByStyleId() throws Exception {
        GetStyleColorByStyleIdReq req = new GetStyleColorByStyleIdReq();

        GetStyleColorByStyleIdResp resp = jingzhenguService.getStyleColorByStyleId(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void getModifiedIds() throws Exception {
        GetModifiedIdsReq req = new GetModifiedIdsReq();
        GetModifiedIdsResp resp = jingzhenguService.getModifiedIds(req);
        System.out.println(JSON.toJSONString(resp));
    }

}