package com.glsx.vasp.admin.common.exception;

import com.glsx.vasp.framework.web.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.glsx.vasp.admin.common.exception.ResultCodeEnum.*;

@Slf4j
@RestControllerAdvice
public class ShiroExceptionHandler {

    @ExceptionHandler(ShiroException.class)
    public R doHandleShiroException(ShiroException e) {
        if (e instanceof IncorrectCredentialsException)
            return R.error(INCORRECT_CREDENTIALS.getCode(), INCORRECT_CREDENTIALS.getMsg());
        else if (e instanceof UnknownAccountException)
            return R.error(UNKNOWN_ACCOUNT.getCode(), UNKNOWN_ACCOUNT.getMsg());
        else if (e instanceof LockedAccountException)
            return R.error(LOCKED_ACCOUNT.getCode(), LOCKED_ACCOUNT.getMsg());
        else if (e instanceof IncorrectCaptchaException) {
            return R.error(INCORRECT_CAPTCHA.getCode(), INCORRECT_CAPTCHA.getMsg());
        }
        return R.error(LOGIN_FAIL.getCode(), LOGIN_FAIL.getMsg());
    }

}
