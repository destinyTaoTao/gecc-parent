package com.glsx.vasp.admin.modules.user.service;

import com.glsx.vasp.enums.SysConstants;
import com.glsx.vasp.system.entity.SysUser;
import com.glsx.vasp.system.repository.ISysUserRepository;
import com.glsx.vasp.utils.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liuyf
 * @Title UserServiceImpl.java
 * @Package com.hflw.vasp.service.impl
 * @Description 用户信息
 * @date 2019年10月24日 下午2:37:40
 */
@Service
public class UserService {

    @Resource
    private ISysUserRepository repository;

    @Autowired
    private HashedCredentialsMatcher hcm;

    public SysUser getById(Long id) {
        return repository.getOne(id);
    }

    public SysUser findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public SysUser addUser(SysUser user) {

        String password = user.getPassword();

        // uuid获取随机字符串，作为盐值。
        String salt = StringUtils.generateRandomCode(false, 4);

        //add Salt to password
        //user.getCredentialsSalt
        SimpleHash hash = new SimpleHash(hcm.getHashAlgorithmName(), password, salt, hcm.getHashIterations());
        //重新赋值
        user.setSalt(salt);
        user.setPassword(hash.toString());
        user.setEnableStatus(SysConstants.EnableStatus.enable.getCode());
        user.setCreateTime(new Date());
        repository.save(user);
        return user;
    }

}
