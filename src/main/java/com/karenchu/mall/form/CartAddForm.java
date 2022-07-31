package com.karenchu.mall.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 添加商品表單
 */
@Data
@ApiModel(description = "添加商品表單")
public class CartAddForm {

    @NotNull
    @ApiModelProperty(value = "產品id", required = true)
    private Integer productId;

    @ApiModelProperty(value = "是否選中")
    private Boolean selected = true;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }


}
