package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CityListItem {

    @JSONField(name = "city_id")
    private Integer cityId;

    @JSONField(name = "city_name")
    private String cityName;

    @JSONField(name = "admin_code")
    private String adminCode;

    @JSONField(name = "initial")
    private String initial;

    @JSONField(name = "prov_id")
    private Integer provId;

    @JSONField(name = "prov_name")
    private String provName;

}
