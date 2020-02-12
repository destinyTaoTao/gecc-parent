package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class AbstractChe300Response {

    @JSONField(name = "status")
    private Integer status;

    @JSONField(name = "error_msg")
    private String errorMsg;

//    @JSONField(name = "data")
//    private String data;

}
