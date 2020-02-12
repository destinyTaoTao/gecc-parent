package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class CarBrandListResp extends AbstractChe300Response {

    @JSONField(name = "brand_list")
    private List<CarBrandListItem> brandList;

}
