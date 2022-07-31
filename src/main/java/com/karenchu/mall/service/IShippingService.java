package com.karenchu.mall.service;

import com.github.pagehelper.PageInfo;
import com.karenchu.mall.form.ShippingForm;
import com.karenchu.mall.vo.ResponseVo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
