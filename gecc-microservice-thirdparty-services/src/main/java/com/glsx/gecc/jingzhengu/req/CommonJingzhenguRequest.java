package com.glsx.gecc.jingzhengu.req;

import lombok.Data;

@Data
public class CommonJingzhenguRequest {

    private String partnerId;
    private String sequenceId;
    private String sign;
    private String body;

}
