package com.karenchu.mall.service.impl;

import com.karenchu.mall.MallApplicationTests;
import com.karenchu.mall.enums.ResponseEnum;
import com.karenchu.mall.enums.RoleEnum;
import com.karenchu.mall.pojo.User;
import com.karenchu.mall.service.IUserService;
import com.karenchu.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "karen";
    public static final String PASSWORD = "123456";

    @Autowired
    private IUserService userService;

    @Before
    public void register() {
        User user = new User(USERNAME, PASSWORD, "karen@gmail.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}