package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class CarModelListResp extends AbstractChe300Response {

    @JSONField(name = "model_list")
    private List<CarModelListItem> modelList;

}
