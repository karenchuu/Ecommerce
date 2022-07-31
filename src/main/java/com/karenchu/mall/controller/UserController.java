package com.karenchu.mall.controller;

import com.karenchu.mall.consts.MallConst;
import com.karenchu.mall.form.UserLoginForm;
import com.karenchu.mall.form.UserRegisterForm;
import com.karenchu.mall.pojo.User;
import com.karenchu.mall.service.IUserService;
import com.karenchu.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 用戶模塊 Controller
 * Created by Karen on 2022/4/24.
 */
@Api(tags = "UserController", description = "用戶管理模塊")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用戶註冊")
    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        // dto
        return userService.register(user);
    }

    @ApiOperation(value = "用戶登入")
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession session) {

        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        // 設置 Session
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        log.info("/login sessionId={}", session.getId());
        return userResponseVo;
    }

    // session保存在內存裡，改進版：token+redis
    @ApiOperation(value = "獲取用戶登入資訊")
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        // 取得 Session
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @ApiOperation(value = "用戶登出")
    @PostMapping("/user/logout")
    /**
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory} getSessionTimeoutInMinutes
     */
    public ResponseVo logout(HttpSession session) {
        log.info("/user/logout sessionId={}", session.getId());
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
