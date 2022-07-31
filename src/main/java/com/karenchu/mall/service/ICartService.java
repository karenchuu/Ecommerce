package com.karenchu.mall.service;

import com.karenchu.mall.form.CartAddForm;
import com.karenchu.mall.form.CartUpdateForm;
import com.karenchu.mall.pojo.Cart;
import com.karenchu.mall.vo.CartVo;
import com.karenchu.mall.vo.ResponseVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
