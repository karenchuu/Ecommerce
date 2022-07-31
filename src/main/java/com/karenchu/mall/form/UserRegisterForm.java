package com.karenchu.mall.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "使用者註冊資訊")
public class UserRegisterForm {

    @NotBlank
    @ApiModelProperty(value = "使用者名稱", required = true)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "使用者密碼", required = true)
    private String password;

    @NotBlank
    @ApiModelProperty(value = "使用者信箱", required = true)
    private String email;
}
