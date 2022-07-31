package com.karenchu.mall.enums;

public enum PaymentTypeEnum {

    PAY_ONLINE(1),
    ;

    Integer code;

    public Integer getCode() {
        return code;
    }

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
