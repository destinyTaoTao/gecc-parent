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
@Table(name = "d_car_source")
@ApiModel("车源")
public class CarSource extends BaseEntity {

    /**
     * 入库时间
     */
    @Column(name = "storage_time")
    private Date storageTime;

    private String icon;

    /**
     * 车架号/车辆识别码
     */
    private String vin;

    /**
     * 出厂年份
     */
    @Column(name = "manufacturer_year")
    private Integer manufacture_year;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "model_id")
    private Integer modelId;

    private String color;

    @Column(name = "manufacturer_guided_price")
    private BigDecimal manufacturerGuidedPrice;

    @Column(name = "monthly_payment")
    private BigDecimal monthlyPayment;

    /**
     * 车源城市code
     */
    private String city;

}
