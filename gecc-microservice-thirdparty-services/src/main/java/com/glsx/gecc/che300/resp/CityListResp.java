package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class CityListResp extends AbstractChe300Response {

    @JSONField(name = "city_list")
    private List<CityListItem> cityList;

}
