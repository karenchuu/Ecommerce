package com.karenchu.mall.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "使用者登入資訊")
public class UserLoginForm {

    @NotBlank
    @ApiModelProperty(value = "使用者名稱", required = true)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "使用者密碼", required = true)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
