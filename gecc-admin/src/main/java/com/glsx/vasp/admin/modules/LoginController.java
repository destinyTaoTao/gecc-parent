package com.glsx.vasp.admin.modules;


import com.glsx.vasp.admin.common.exception.ResultCodeEnum;
import com.glsx.vasp.framework.exception.BusinessException;
import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.system.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/**
 * @author liuyf
 * @Title UserController.java
 * @Package com.hflw.vasp.controller
 * @Description 登录
 * @date 2019年10月24日 下午2:02:54
 */
@Validated
@RestController
public class LoginController extends AbstractController {

    @Autowired
    private HashedCredentialsMatcher hcm;

    @PostMapping(value = "/login")
    @ResponseBody
    public R login(HttpServletRequest request,
                   @NotBlank(message = "用户名不能为空") String username,
                   @NotBlank(message = "密码不能为空") String password,
                   @NotBlank(message = "验证码不能为空") String captcha) {
//        UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(username, password.toCharArray(), true, captcha);

        // 校验验证码
        doCaptchaValidate(request, captcha);

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        SecurityUtils.getSubject().login(token);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return R.ok().data(session.getId());
    }

    /**
     * 验证码校验
     *
     * @param request
     * @param captcha
     */
    protected void doCaptchaValidate(HttpServletRequest request, String captcha) {
        // 从session中获取图形吗字符串
        String kaptcha = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //删除缓存验证码
        request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 校验
        if (kaptcha == null || !kaptcha.equals(captcha)) {
            throw BusinessException.create(ResultCodeEnum.INCORRECT_CAPTCHA.getCode(), ResultCodeEnum.INCORRECT_CAPTCHA.getMsg());
        }
    }

    @RequestMapping(value = "/logout")
    public R logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }

    @RequestMapping(value = "/index")
    public R index() {
        //登录成功，进入首页
        return R.ok();
    }

    @GetMapping(value = "/info")
    public R info() {
        SysUser user = getSessionUser();
        return R.ok().data(user);
    }

}
