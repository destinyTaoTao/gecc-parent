package com.glsx.vasp.modules.entity;

import com.glsx.vasp.system.entity.BaseSysUser;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 合作商/商户用户表
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_partner_user")
public class PartnerUser extends BaseSysUser {

    @Column(name = "partner_code")
    private Long partnerCode;

}
