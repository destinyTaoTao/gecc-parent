package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class CarBrandListItem {

    @JSONField(name = "brand_id")
    private Integer brandId;

    @JSONField(name = "brand_name")
    private String brandName;

    @JSONField(name = "initial")
    private String initial;

    @JSONField(name = "update_time")
    private Date updateTime;

}
