package com.karenchu.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karenchu.mall.MallApplicationTests;
import com.karenchu.mall.enums.ResponseEnum;
import com.karenchu.mall.form.CartAddForm;
import com.karenchu.mall.form.CartUpdateForm;
import com.karenchu.mall.vo.CartVo;
import com.karenchu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CartServiceTest extends MallApplicationTests {

    @Autowired
    private  ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Integer productId = 26;
    private Integer uid = 1;

    @Before
    public void add() {
        log.info("【新增購物車】...");
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, form);
        log.info("{list={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("{list={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(5);
        form.setSelected(false);
        ResponseVo<CartVo> responseVo = cartService.update(uid, productId, form);
        log.info("{result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo<CartVo> responseVo = cartService.delete(uid, productId);
        log.info("{result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());

    }

    @Test
    public void selectAll() {
        log.info("【刪除購物車】...");
        ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
        log.info("{result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
        log.info("{result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void sum() {
        ResponseVo<Integer> list = cartService.sum(uid);
        log.info("{result={}", gson.toJson(list));
    }
}