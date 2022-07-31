package com.karenchu.mall.service.impl;

import com.karenchu.mall.dao.UserMapper;
import com.karenchu.mall.enums.ResponseEnum;
import com.karenchu.mall.enums.RoleEnum;
import com.karenchu.mall.pojo.User;
import com.karenchu.mall.service.IUserService;
import com.karenchu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 註冊
     * @param user
     */
    @Override
    public ResponseVo<User> register(User user) {
        // username 不能重複
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        // email 不能重複
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }
        user.setRole(RoleEnum.CUSTOMER.getCode());
        // MD5 雜湊 摘要算法(Spring自帶)
        user.setPassword(DigestUtils.md5DigestAsHex(
                        user.getPassword().getBytes(StandardCharsets.UTF_8)
        ));

        // 寫入數據庫
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            // 用戶不存在(返回: 用戶名或密碼錯誤)
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            // 密碼錯誤(返回: 用戶名或密碼錯誤)
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }

}
