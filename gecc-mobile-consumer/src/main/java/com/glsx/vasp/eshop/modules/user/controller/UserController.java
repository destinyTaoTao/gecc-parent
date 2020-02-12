package com.glsx.vasp.eshop.modules.user.controller;


import com.glsx.vasp.eshop.modules.AbstractController;
import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.modules.entity.Customer;
import com.glsx.vasp.eshop.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyf
 * @Title UserController.java
 * @Package com.hflw.vasp.controller
 * @Description 登录
 * @date 2019年10月24日 下午2:02:54
 */
@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/info")
    public R index() {
        Customer user = getSessionUser();
        return R.ok().data(user);
    }

}
