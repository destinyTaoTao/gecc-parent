package com.glsx.gecc.jingzhengu.service.impl;

import com.glsx.gecc.jingzhengu.req.*;
import com.glsx.gecc.jingzhengu.resp.*;
import com.glsx.gecc.jingzhengu.service.IJingzhenguService;
import com.glsx.gecc.jingzhengu.util.JingzhenguUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class JingzhenguServiceImpl implements IJingzhenguService {

    @Resource
    private JingzhenguUtils utils;

    @Override
    public GetProvinceListInfoResp getProvinceListInfo(GetProvinceListInfoReq req) {
        GetProvinceListInfoResp resp = utils.access(req, GetProvinceListInfoResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetProvCityListInfoResp getProvCityListInfo(GetProvCityListInfoReq req) {
        GetProvCityListInfoResp resp = utils.access(req, GetProvCityListInfoResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetMakeByAllResp getMakeByAll(GetMakeByAllReq req) {
        GetMakeByAllResp resp = utils.access(req, GetMakeByAllResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetSubModelByMakeIdResp getSubModelByMakeId(GetSubModelByMakeIdReq req) {
        GetSubModelByMakeIdResp resp = utils.access(req, GetSubModelByMakeIdResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetModelsResp getModels(GetModelsReq req) {
        GetModelsResp resp = utils.access(req, GetModelsResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetStyleByModelIdResp getStyleByModelId(GetStyleByModelIdReq req) {
        GetStyleByModelIdResp resp = utils.access(req, GetStyleByModelIdResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetStylesResp getStyles(GetStylesReq req) {
        GetStylesResp resp = utils.access(req, GetStylesResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetStyleColorByStyleIdResp getStyleColorByStyleId(GetStyleColorByStyleIdReq req) {
        GetStyleColorByStyleIdResp resp = utils.access(req, GetStyleColorByStyleIdResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetModifiedIdsResp getModifiedIds(GetModifiedIdsReq req) {
        GetModifiedIdsResp resp = utils.access(req, GetModifiedIdsResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

}
