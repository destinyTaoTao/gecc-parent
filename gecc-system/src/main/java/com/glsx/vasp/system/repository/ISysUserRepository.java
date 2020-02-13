package com.glsx.vasp.system.repository;

import com.glsx.vasp.base.BaseRepository;
import com.glsx.vasp.system.entity.SysUser;

import java.io.Serializable;

public interface ISysUserRepository extends BaseRepository<SysUser, Long>, Serializable {

    SysUser findByUsername(String username);

}
