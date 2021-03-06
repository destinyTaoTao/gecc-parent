package com.glsx.vasp.eshop.modules.cities.service;

import com.glsx.vasp.framework.components.RedisCacheUtils;
import com.glsx.vasp.framework.constant.ConstantKeys;
import com.glsx.vasp.system.entity.SysCity;
import com.glsx.vasp.system.repository.IBaseCitiesRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


@Service
public class BaseCitiesService {

    @Resource
    private IBaseCitiesRepository repository;

    @Autowired
    private RedisCacheUtils redisCacheUtil;

    public List<SysCity> list(Map<String, String> params) {
        String provinceCode = params.get("provinceCode");
        List<SysCity> list = redisCacheUtil.getListByPrex(ConstantKeys.REDIS_CITY_KEY + provinceCode);
        Collections.sort(list, Comparator.comparing(SysCity::getCode));

        SysCity city = new SysCity();
        city.setProvinceCode(provinceCode);
        Example<SysCity> example = Example.of(city);
        if (CollectionUtils.isEmpty(list)) list = repository.findAll(example);
        return list;
    }
}
