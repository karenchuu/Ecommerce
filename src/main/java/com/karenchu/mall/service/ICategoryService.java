package com.karenchu.mall.service;

import com.karenchu.mall.vo.CategoryVo;
import com.karenchu.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

    /**
     * 查詢所有分類
     */
    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
