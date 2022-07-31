package com.karenchu.mall.enums;

/**
 * 商品狀態:1-在售 2-下架 3-刪除
 */
public enum ProductStatusEnum {
    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3)

    ;

    Integer code;

    public Integer getCode() {
        return code;
    }

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
