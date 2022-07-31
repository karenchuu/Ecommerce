package com.karenchu.mall.enums;

/**
 * 訂單狀態:0-已取消，10-未付款，20-已付款，40-已發貨，50-交易成功，60-交易關閉
 */
public enum OrderStatusEnum {

    CANCEL(0, "已取消"),

    NO_PAY(10, "未付款"),

    PAID(20, "已付款"),

    SHIPPED(40, "已發貨"),

    TRADE_SUCCESS(50, "交易成功"),

    TRADE_CLOSE(60, "交易成功"),

    ;

    Integer code;

    String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
