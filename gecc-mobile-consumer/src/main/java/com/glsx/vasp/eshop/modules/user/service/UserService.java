package com.glsx.vasp.eshop.modules.user.service;

import com.glsx.vasp.eshop.common.constant.Constants;
import com.glsx.vasp.modules.repository.ICustomerDao;
import com.glsx.vasp.modules.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author liuyf
 * @Title UserServiceImpl.java
 * @Package com.hflw.vasp.service.impl
 * @Description 用户信息
 * @date 2019年10月24日 下午2:37:40
 */
@Service
public class UserService {

    @Autowired
    private ICustomerDao userDao;

    public Customer getUserByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    public Long saveOrUpdate(Customer u) {
        Date now = new Date();
        if (u.getId() == null) u.setCreateTime(now);
        u.setUpdateTime(now);
        u.setDelFlag(Constants.NOT_DEL);
        u.setEnableStatus(Constants.ENABLE_STATUS_CHECK);
        userDao.save(u);
        return u.getId();
    }

    public void update(Customer u) {
        u.setUpdateTime(new Date());
        userDao.save(u);
    }

    public Customer findByWxOpenId(String wxOpenId) {
        return userDao.findByWxOpenId(wxOpenId);
    }

    public Customer findByMiniOpenId(String miniOpenId) {
        return userDao.findByMiniOpenId(miniOpenId);
    }

    public Customer findById(Long id) {
        Optional<Customer> optional = userDao.findById(id);
        return optional.get();
    }

}
