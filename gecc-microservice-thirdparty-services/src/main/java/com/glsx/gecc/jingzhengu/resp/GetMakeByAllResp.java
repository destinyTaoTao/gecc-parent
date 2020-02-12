package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetMakeByAllResp extends AbstractJingzhenguResponse {

    private List<GetMakeByAllItem> data;

}
