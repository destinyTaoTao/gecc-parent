package com.glsx.vasp.store.modules;

import com.glsx.vasp.framework.controller.BaseController;
import com.glsx.vasp.modules.entity.StoreUser;
import com.glsx.vasp.store.common.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liuyf
 * @Title BaseController.java
 * @Package com.hflw.vasp.controller
 * @Description
 * @date 2019年10月24日 下午2:24:00
 */
@Controller
public class AbstractController extends BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    /**
     * 从session中获取当前用户
     *
     * @return
     */
    @Override
    public StoreUser getSessionUser() {
        StoreUser user = (StoreUser) session.getAttribute(Constants.SESSION_LOGIN_USER);
        if (user == null || StringUtils.isBlank(user.getPhone())) {
            return null;
        }
        return user;
    }

    @Override
    public String getAccount() {
        StoreUser user = getSessionUser();
        if (user != null) {
            return user.getUsername();
        }
        return null;
    }

    @Override
    public Long getUserId() {
        StoreUser user = getSessionUser();
        if (user != null) {
            return user.getId();
        }
        return null;
    }

    protected void checkDTOParams(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //throw new 带验证码的验证错误异常
        }
    }

}
