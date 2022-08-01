package com.karenchu.mall.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentTypeEnum {

    PAY_ONLINE(1, "在線支付"),
    ;

    Integer code;

    String desc;

    PaymentTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static Map<Integer, PaymentTypeEnum> buildMap() {
        Map<Integer, PaymentTypeEnum> map = new HashMap<Integer, PaymentTypeEnum>();
        PaymentTypeEnum[] values = PaymentTypeEnum.values();
        for (PaymentTypeEnum value : values) {
            map.put(value.getCode(), value);
        }

        return map;
    }
}
