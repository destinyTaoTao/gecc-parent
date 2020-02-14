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
@ApiModel("销售线索")
public class Clue extends BaseEntity {

    private String sn;

    private String name;

    private String phone;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 旧车车型id
     */
    @Column(name = "old_carmodel_id")
    private Long oldCarModelId;

}
