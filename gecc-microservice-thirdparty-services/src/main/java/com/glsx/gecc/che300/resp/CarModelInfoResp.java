package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CarModelInfoResp extends AbstractChe300Response {

    @JSONField(name = "model")
    private CarModelInfoItem modelInfo;

}
