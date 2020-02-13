package com.glsx.vasp.eshop.modules.province.service;

import com.glsx.vasp.framework.components.RedisCacheUtils;
import com.glsx.vasp.framework.constant.ConstantKeys;
import com.glsx.vasp.system.entity.SysProvince;
import com.glsx.vasp.system.repository.ISysProvinceRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class BaseProvincesService {

    @Resource
    private ISysProvinceRepository repository;

    @Autowired
    private RedisCacheUtils redisCacheUtil;

    public List<SysProvince> list() {
        List<SysProvince> list = redisCacheUtil.getCacheList(ConstantKeys.REDIS_PROVINCES_KEY);
        //排序
        Collections.sort(list, Comparator.comparing(SysProvince::getCode));
        if (CollectionUtils.isEmpty(list)) list = repository.findAll();
        return list;
    }
}
