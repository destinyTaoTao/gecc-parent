package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetModelsResp extends AbstractJingzhenguResponse {

    private List<GetModelsItem> data;

}
