package com.karenchu.mall.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShippingForm {

    @NotBlank
    @ApiModelProperty(value = "收貨姓名", required = true)
    private String receiverName;

    @ApiModelProperty(value = "收貨固定電話")
    private String receiverPhone;

    @NotBlank
    @ApiModelProperty(value = "收貨手機號碼", required = true)
    private String receiverMobile;

    @NotBlank
    @ApiModelProperty(value = "省份", required = true)
    private String receiverProvince;

    @NotBlank
    @ApiModelProperty(value = "城市", required = true)
    private String receiverCity;

    @NotBlank
    @ApiModelProperty(value = "區/縣", required = true)
    private String receiverDistrict;

    @NotBlank
    @ApiModelProperty(value = "詳細地址", required = true)
    private String receiverAddress;

    @NotBlank
    @ApiModelProperty(value = "郵遞區號", required = true)
    private String receiverZip;
}
