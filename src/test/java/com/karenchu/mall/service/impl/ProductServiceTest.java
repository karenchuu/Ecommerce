package com.karenchu.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.karenchu.mall.MallApplicationTests;
import com.karenchu.mall.enums.ResponseEnum;
import com.karenchu.mall.service.IProductService;
import com.karenchu.mall.vo.ProductDetailVo;
import com.karenchu.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 1, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}