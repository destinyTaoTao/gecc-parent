package com.glsx.vasp.store.modules;


import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.modules.entity.StoreUser;
import com.glsx.vasp.weixin.common.config.WxMaConfiguration;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuyf
 * @Title UserController.java
 * @Package com.hflw.vasp.controller
 * @Description 登录
 * @date 2019年10月24日 下午2:02:54
 */
@Slf4j
@Validated
@RestController
public class LoginController extends AbstractController {

    /**
     * 登陆接口
     */
    @PostMapping(value = "/register", produces = "application/json")
    public R login(@RequestBody Map<String, Object> params) {
        String js_code = (String) params.get("js_code");
        if (StringUtils.isBlank(js_code)) return R.error("empty jscode");

        // 门店小程序的appid
        String appid = "";
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(js_code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());

            //增加自己的逻辑，关联业务相关数据
            //todo openid入库
            //todo 设置session
            return R.ok().data(session);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return R.error(e.getMessage());
        }
    }


    @RequestMapping(value = "/index")
    public R index() {
        //登录成功，进入首页
        return R.ok();
    }

    @GetMapping(value = "/info")
    public R info() {
        StoreUser user = getSessionUser();
        return R.ok().data(user);
    }

}
