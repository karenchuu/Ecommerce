package com.karenchu.mall.controller;

import com.karenchu.mall.service.ICategoryService;
import com.karenchu.mall.vo.CategoryVo;
import com.karenchu.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分類模塊 Controller
 * Created by Karen on 2022/5/5.
 */
@Api(tags = "CategoriesController", description = "分類管理模塊")
@RestController
@Slf4j
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @ApiOperation(value = "取得所有分類")
    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> categories() {
        ResponseVo<List<CategoryVo>> categoryResponseVo = categoryService.selectAll();
        return categoryResponseVo;
    }
}
