package com.glsx.gecc.jingzhengu.service;

import com.glsx.gecc.jingzhengu.req.*;
import com.glsx.gecc.jingzhengu.resp.*;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "jingzhenguService")
public interface JingzhenguService {

    public GetProvinceListInfoResp getProvinceListInfo(GetProvinceListInfoReq req);

    public GetProvCityListInfoResp getProvCityListInfo(GetProvCityListInfoReq req);

    public GetMakeByAllResp getMakeByAll(GetMakeByAllReq req);

    public GetSubModelByMakeIdResp getSubModelByMakeId(GetSubModelByMakeIdReq req);

    public GetModelsResp getModels(GetModelsReq req);

    public GetStyleByModelIdResp getStyleByModelId(GetStyleByModelIdReq req);

    public GetStylesResp getStyles(GetStylesReq req);

    public GetStyleColorByStyleIdResp getStyleColorByStyleId(GetStyleColorByStyleIdReq req);

    public GetModifiedIdsResp getModifiedIds(GetModifiedIdsReq req);

    public EstimateInfoResp estimateInfo(EstimateInfoReq req);

    public ResidualRatioResp residualRatio(ResidualRatioReq req);

    public EstimateFastResidualResp estimateFastResidual(GetModifiedIdsReq req);

    public PriceAnalysisResp priceAnalysis(PriceAnalysisReq req);

}