package com.glsx.vasp.partner.modules;


import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.modules.entity.PartnerUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping(value = "/login")
    public R login(String username, String verifyCode) {
        //增加自己的逻辑，关联业务相关数据
        //todo openid入库
        //todo 设置session
        String sessionId = "";
        return R.ok().data(sessionId);
    }

    @RequestMapping(value = "/index")
    public R index() {
        //登录成功，进入首页
        return R.ok();
    }

    @GetMapping(value = "/info")
    public R info() {
        PartnerUser user = getSessionUser();
        return R.ok().data(user);
    }

}
