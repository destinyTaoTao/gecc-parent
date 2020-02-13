package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import com.glsx.vasp.system.entity.BaseSysUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_sales_lead")
@ApiModel("销售线索")
public class SalesLead extends BaseEntity {

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

    /**
     * 新车车型id
     */
    @Column(name = "new_carmodel_id")
    private Long newCarModelId;

}
