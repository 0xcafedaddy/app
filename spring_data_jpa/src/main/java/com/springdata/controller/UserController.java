package com.springdata.controller;

import com.springdata.entity.Tb_user;
import com.springdata.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/15.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceI userService;

    @RequestMapping("/findById/{id}")
    @ResponseBody
    public Tb_user findById(@PathVariable long id){
        return userService.getById(id);
    }
}
