package com.glsx.gecc.jingzhengu.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetSubModelByMakeIdResp extends AbstractJingzhenguResponse {

    private List<GetSubModelByMakeIdItem> data;

}
