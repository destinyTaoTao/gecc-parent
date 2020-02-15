package com.glsx.gecc.jingzhengu.service.impl;

import com.glsx.gecc.jingzhengu.req.*;
import com.glsx.gecc.jingzhengu.resp.*;
import com.glsx.gecc.jingzhengu.service.JingzhenguService;
import com.glsx.gecc.jingzhengu.util.EncryptUtil;
import com.glsx.gecc.jingzhengu.util.JingzhenguUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class JingzhenguServiceImpl implements JingzhenguService {

    @Resource
    private JingzhenguUtils utils;

    @Override
    public GetProvinceListInfoResp getProvinceListInfo(GetProvinceListInfoReq req) {
        GetProvinceListInfoResp resp = utils.accessNvapiUrl("provinceAndCity/",req, GetProvinceListInfoResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        String data = EncryptUtil.DES3Decrypt(EncryptUtil.BASE64Decrypt(resp.getBody()),"");

        return resp;
    }

    @Override
    public GetProvCityListInfoResp getProvCityListInfo(GetProvCityListInfoReq req) {
        GetProvCityListInfoResp resp = utils.accessNvapiUrl("provinceAndCity/",req, GetProvCityListInfoResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetMakeByAllResp getMakeByAll(GetMakeByAllReq req) {
        GetMakeByAllResp resp = utils.accessNvapiUrl("external/",req, GetMakeByAllResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetSubModelByMakeIdResp getSubModelByMakeId(GetSubModelByMakeIdReq req) {
        GetSubModelByMakeIdResp resp = utils.accessNvapiUrl("external/",req, GetSubModelByMakeIdResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetModelsResp getModels(GetModelsReq req) {
        GetModelsResp resp = utils.accessNvapiUrl("external/",req, GetModelsResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetStyleByModelIdResp getStyleByModelId(GetStyleByModelIdReq req) {
        GetStyleByModelIdResp resp = utils.accessNvapiUrl("external/",req, GetStyleByModelIdResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetStylesResp getStyles(GetStylesReq req) {
        GetStylesResp resp = utils.accessNvapiUrl("external/",req, GetStylesResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetStyleColorByStyleIdResp getStyleColorByStyleId(GetStyleColorByStyleIdReq req) {
        GetStyleColorByStyleIdResp resp = utils.accessNvapiUrl("external/",req, GetStyleColorByStyleIdResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public GetModifiedIdsResp getModifiedIds(GetModifiedIdsReq req) {
        GetModifiedIdsResp resp = utils.accessNvapiUrl("external/",req, GetModifiedIdsResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public EstimateInfoResp estimateInfo(EstimateInfoReq req) {
        EstimateInfoResp resp = utils.accessGuzhiUrl("estimate/",req, EstimateInfoResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public ResidualRatioResp residualRatio(ResidualRatioReq req) {
        ResidualRatioResp resp = utils.accessGuzhiUrl("estimate/",req, ResidualRatioResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public EstimateFastResidualResp estimateFastResidual(GetModifiedIdsReq req) {
        EstimateFastResidualResp resp = utils.accessGuzhiUrl("estimate/",req, EstimateFastResidualResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

    @Override
    public PriceAnalysisResp priceAnalysis(PriceAnalysisReq req) {
        PriceAnalysisResp resp = utils.accessGuzhiUrl("residualRatio/",req, PriceAnalysisResp.class);
        if (resp == null || resp.getErrorCode() != 0) return null;

        return resp;
    }

}
