package com.glsx.vasp.weixin.modules.controller;


import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.weixin.common.config.WxMaConfiguration;
import me.chanjar.weixin.common.WxType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/wx/config/")
public class WxConfigController {

    /**
     * 登陆接口
     */
    @GetMapping("/get")
    public R get(String type) {
        if (StringUtils.isBlank(type)) return R.error("empty type");

        if (WxType.MP.name().equals(type)) {

        } else if (WxType.MiniApp.name().equals(type)) {

        }
        Set<String> appidSet = WxMaConfiguration.getProperties();

        return R.ok().data(appidSet);
    }



}
