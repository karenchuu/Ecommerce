package com.karenchu.mall.service;

import com.github.pagehelper.PageInfo;
import com.karenchu.mall.vo.ProductDetailVo;
import com.karenchu.mall.vo.ResponseVo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
