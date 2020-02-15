package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_customer_old_car_info")
@ApiModel("客户旧车信息")
public class CustomerOldCarInfo extends BaseEntity {

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * 车型id
     */
    @Column(name = "car_model_id")
    private Long carModelId;

    /**
     * 里程数
     */
    @Column(name = "mileage")
    private Float mileage;

    /**
     * 上牌日期
     */
    @Column(name = "license_date")
    private Date licenseDate;

    /**
     * 上牌城市code
     */
    @Column(name = "license_city")
    private String licenseCity;

    /**
     * 估价
     */
    @Column(name = "valuation")
    private BigDecimal valuation;

}
