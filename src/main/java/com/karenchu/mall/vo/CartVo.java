package com.karenchu.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 購物車
 */
@Data
public class CartVo {

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;

    private List<CartProductVo> cartProductVoList;

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public Boolean getSelectedAll() {
        return selectedAll;
    }

    public void setSelectedAll(Boolean selectedAll) {
        this.selectedAll = selectedAll;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Integer getCartTotalQuantity() {
        return cartTotalQuantity;
    }

    public void setCartTotalQuantity(Integer cartTotalQuantity) {
        this.cartTotalQuantity = cartTotalQuantity;
    }


}
