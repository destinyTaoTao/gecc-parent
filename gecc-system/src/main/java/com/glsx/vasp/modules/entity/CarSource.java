package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_car_source")
@ApiModel("车源")
public class CarSource extends BaseEntity {

//    private String picUrl;

    private String vin;

    private Integer year;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "model_id")
    private Integer modelId;

    private String color;

    private BigDecimal price;

    private String city;

}
