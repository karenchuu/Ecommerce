package com.karenchu.mall.pojo;

import lombok.Data;

@Data
public class Cart {

    private Integer quantity;

    private Boolean productSelected;

    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(Boolean productSelected) {
        this.productSelected = productSelected;
    }

    public Cart() {

    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
