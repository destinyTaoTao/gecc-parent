package com.glsx.gecc.jingzhengu.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class AbstractJingzhenguResponse {

    @JSONField(name = "errorCode")
    private Integer errorCode;

    @JSONField(name = "errorMessage")
    private String errorMessage;

    @JSONField(name = "sequenceId")
    private String sequenceId;

    @JSONField(name = "timeStamp")
    private Long timeStamp;

    @JSONField(name = "sign")
    private String sign;

    @JSONField(name = "body")
    private String body;

}
