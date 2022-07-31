package com.karenchu.mall.form;

import lombok.Data;

@Data
public class CartUpdateForm {

    private Integer quantity;

    private Boolean selected;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
