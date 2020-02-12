package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UpdatedModelIds {

    @JSONField(name = "modelIds")
    private Integer[] modelIds;

}
