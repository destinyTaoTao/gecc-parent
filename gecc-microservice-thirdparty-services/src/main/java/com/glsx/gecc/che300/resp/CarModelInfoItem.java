package com.glsx.gecc.che300.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CarModelInfoItem {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "retain_star")
    private String retainStar;

    @JSONField(name = "liter")
    private String liter;

    @JSONField(name = "gear")
    private String gear;

    @JSONField(name = "price")
    private BigDecimal price;

    @JSONField(name = "discharge")
    private String discharge;

    @JSONField(name = "year")
    private String year;

    @JSONField(name = "min_reg_year")
    private String minRegYear;

    @JSONField(name = "max_reg_year")
    private String maxRegYear;

    @JSONField(name = "update_time")
    private Date updateTime;

    @JSONField(name = "brand_id")
    private Integer brandId;

    @JSONField(name = "series_id")
    private Integer seriesId;

    @JSONField(name = "fuel_type")
    private String fuelType;

    @JSONField(name = "is_green")
    private Integer isGreen;

}
