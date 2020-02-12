package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetStyleByModelIdResp extends AbstractJingzhenguResponse {

    private List<GetStyleByModelIdItem> data;

}
