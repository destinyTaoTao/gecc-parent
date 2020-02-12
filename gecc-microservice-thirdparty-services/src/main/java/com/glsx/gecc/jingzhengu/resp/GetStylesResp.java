package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetStylesResp extends AbstractJingzhenguResponse {

    private List<GetStylesItem> data;

}
