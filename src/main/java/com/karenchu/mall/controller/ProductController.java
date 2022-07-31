package com.karenchu.mall.controller;

import com.github.pagehelper.PageInfo;
import com.karenchu.mall.service.IProductService;
import com.karenchu.mall.vo.ProductDetailVo;
import com.karenchu.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理模塊 Controller
 * Created by Karen on 2022/5/7.
 */
@Api(tags = "ProductController", description = "商品管理模塊")
@RestController
public class ProductController {
    @Autowired
    IProductService productService;

    @ApiOperation(value = "取得商品列表")
    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return productService.list(categoryId, pageNum, pageSize);
    }

    @ApiOperation(value = "取得商品詳情")
    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId) {
        return productService.detail(productId);
    }
}
