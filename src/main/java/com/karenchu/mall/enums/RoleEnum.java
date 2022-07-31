package com.karenchu.mall.enums;

/**
 * 角色0-管理員, 1-普通用戶
 */
public enum RoleEnum {
    ADMIN(0),

    CUSTOMER(1),

    ;

    Integer code;

    public Integer getCode() {
        return code;
    }

    RoleEnum(Integer code) {
        this.code = code;
    }
}
