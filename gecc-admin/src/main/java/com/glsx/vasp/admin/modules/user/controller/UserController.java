package com.glsx.vasp.admin.modules.user.controller;


import com.glsx.vasp.admin.modules.AbstractController;
import com.glsx.vasp.admin.modules.user.dto.UserDTO;
import com.glsx.vasp.admin.modules.user.service.UserService;
import com.glsx.vasp.system.entity.SysUser;
import com.glsx.vasp.framework.web.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping(value = "/info/{id}")
    public R info(@PathVariable("id") Long id) {
        SysUser user = userService.getById(id);
        return R.ok().data(user);
    }

    @PostMapping(value = "/add")
    public R add(@Valid UserDTO userDTO, BindingResult bindingResult) {
        checkDTOParams(bindingResult);

        SysUser user = userDTO.convertTo();
        SysUser saveResultUser = userService.addUser(user);
//        UserDTO result = userDTO.convertFor(saveResultUser);
        return R.ok();
    }

    @PostMapping(value = "/update")
    public R update() {
        return R.ok();
    }

    @PostMapping(value = "/delete")
    public R delete() {
        return R.ok();
    }

}
