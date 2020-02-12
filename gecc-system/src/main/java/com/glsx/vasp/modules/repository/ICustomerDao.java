package com.glsx.vasp.modules.repository;

import com.glsx.vasp.base.BaseRepository;
import com.glsx.vasp.modules.entity.Customer;

import java.io.Serializable;

public interface ICustomerDao extends BaseRepository<Customer, Long>, Serializable {

    Customer findByPhone(String phone);

    Customer findByWxOpenId(String wxOpenId);

    Customer findByMiniOpenId(String miniOpenId);

}
