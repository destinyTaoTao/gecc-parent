package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_clue")
@ApiModel("线索")
public class Clue extends BaseEntity {

    /**
     * 个人客户id
     */
    @Column(name = "consumer_id")
    private Long  consumerId;

    /**
     * 线索编号
     */
    private String sn;

    private String name;

    private String phone;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    private Integer status;

    /**
     * 旧车车型id
     */
    @Column(name = "old_car_model_id")
    private Long oldCarModelId;

    /**
     * 意向车型id
     */
    @Column(name = "car_source_id")
    private Long carSourceId;

    /**
     * 广联换车方案id
     */
    @Column(name = "scheme_gecc_id")
    private Long schemeGeccId;

    /**
     * 传统方案id
     */
    @Column(name = "scheme_tradition_id")
    private Long schemeTraditionId;

}
