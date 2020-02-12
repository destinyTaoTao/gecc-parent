package com.glsx.vasp.weixin.modules.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.weixin.common.config.WxMaConfiguration;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Slf4j
@RestController
@RequestMapping("/wx/user/{appid}")
public class WxMaUserController {

    /**
     * 登陆接口
     */
    @PostMapping(value = "/login", produces = "application/json")
    public R login(@PathVariable String appid, @RequestBody Map<String, Object> params) {
        String js_code = (String) params.get("js_code");
        if (StringUtils.isBlank(js_code)) return R.error("empty jscode");

        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(js_code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            //可以增加自己的逻辑，关联业务相关数据

            //todo openid入库
            //todo 设置session
            return R.ok().data(session);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return R.error(e.getMessage());
        }
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public R info(@PathVariable String appid, String sessionKey,
                      String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return R.error("user check failed");
        }

        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        return R.ok().data(userInfo);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @GetMapping("/phone")
    public R phone(@PathVariable String appid, String sessionKey, String signature,
                       String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return R.error("user check failed");
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);

        return R.ok().data(phoneNoInfo);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @PostMapping("/updateWxUserInfo")
    public R update(@PathVariable String appid, @RequestBody WxMaUserInfo userInfo) {

        return R.ok();
    }

}
