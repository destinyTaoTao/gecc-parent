package com.glsx.vasp.modules.entity;

import com.glsx.vasp.system.entity.BaseSysUser;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 门店用户
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "d_store_user")
public class StoreUser extends BaseSysUser {

    /**
     * 门店的唯一code
     */
    @Column(name = "store_code", length = 64)
    private String storeCode;

    /**
     * 门店的名称
     */
    @Column(name = "store_name", length = 64)
    private String storeName;

}
