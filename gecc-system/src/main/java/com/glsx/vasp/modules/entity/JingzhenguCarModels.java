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
@Table(name = "d_jzg_car_models")
@ApiModel("精真估车型简库")
public class JingzhenguCarModels extends BaseEntity {

    /**
     * 精真估侧车型id
     */
    @Column(name = "model_id")
    private Integer modelId;

    /**
     * 品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * 厂商名称
     */
    private String manufacturer;

    /**
     * 子车系名称
     */
    @Column(name = "series_name")
    private String seriesName;

    /**
     * 车型年款
     */
    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    /**
     * 车型名称
     */
    @Column(name = "model_name")
    private String modelName;

    /**
     * 指导价（万元）
     */
    @Column(name = "guide_price")
    private BigDecimal guidePrice;

    /**
     * 排量（L）
     */
    private Float displacement;

    /**
     * 变速箱类型
     */
    @Column(name = "gearbox_type")
    private String gearboxType;

}
