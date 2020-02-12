package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UpdatedModelParamsInTimeRangeResp extends AbstractChe300Response {

    @JSONField(name = "data")
    private UpdatedModelIds modelIds;

}
