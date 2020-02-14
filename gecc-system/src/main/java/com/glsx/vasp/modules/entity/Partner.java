package com.glsx.vasp.modules.entity;

import com.glsx.vasp.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 合作商/商户
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_partner")
@ApiModel("合作商")
public class Partner extends BaseEntity {

    private String code;
    private String name;
    private String contact;
    private String phone;
    private String address;

}
