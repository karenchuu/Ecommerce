package com.karenchu.mall.service;

import com.karenchu.mall.pojo.User;
import com.karenchu.mall.vo.ResponseVo;

public interface IUserService {

    /**
     * 註冊
     */
    ResponseVo<User> register(User user);

    /**
     * 登入
     */
    ResponseVo<User> login(String username, String password);

}
