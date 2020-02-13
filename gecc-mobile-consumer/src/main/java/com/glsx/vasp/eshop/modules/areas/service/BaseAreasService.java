package com.glsx.vasp.eshop.modules.areas.service;

import com.glsx.vasp.framework.components.RedisCacheUtils;
import com.glsx.vasp.framework.constant.ConstantKeys;
import com.glsx.vasp.system.entity.SysArea;
import com.glsx.vasp.system.repository.IBaseAreasRepository;
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
public class BaseAreasService {

    @Resource
    private IBaseAreasRepository repository;

    @Autowired
    private RedisCacheUtils redisCacheUtil;

    public List<SysArea> searchByCityCode(Map<String, String> params) {
        String cityCode = params.get("cityCode");
        List<SysArea> list = redisCacheUtil.getListByPrex(ConstantKeys.REDIS_AREA_KEY + cityCode);
        Collections.sort(list, Comparator.comparing(SysArea::getCode));

        SysArea area = new SysArea();
        area.setCityCode(cityCode);
        Example<SysArea> example = Example.of(area);
        if (CollectionUtils.isEmpty(list)) list = repository.findAll(example);
        return list;
    }

}
