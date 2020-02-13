package com.glsx.vasp.modules.entity;

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
public class SalesLead extends BaseSysUser implements Serializable {

    private String name;

    private String phone;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

}
