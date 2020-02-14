package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerOldCarInfo extends BaseEntity {

    private Long customer_id;
    private Long car_model_id;// 车型code  关联"车型表"的数据..    车型？？
    private Float mileage;// 里程数
    private Date license_time;// 上牌时间
    private String license_city;// 上牌城市code
    private BigDecimal valuation;//  估价

}
