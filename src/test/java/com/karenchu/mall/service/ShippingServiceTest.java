package com.karenchu.mall.service;

import com.karenchu.mall.MallApplicationTests;
import com.karenchu.mall.enums.ResponseEnum;
import com.karenchu.mall.form.ShippingForm;
import com.karenchu.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public class ShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    private Integer shippingId;

    private ShippingForm form;

    @Before
    public void before() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("娃娃");
        form.setReceiverAddress("糖果路");
        form.setReceiverCity("新北市");
        form.setReceiverMobile("0222334456");
        form.setReceiverPhone("0912345678");
        form.setReceiverProvince("甜點村");
        form.setReceiverDistrict("甜點區");
        form.setReceiverZip("25133");
        this.form = form;

        add();
    }

    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result={}", responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        form.setReceiverCity("高雄市");
        ResponseVo responseVo = shippingService.update(uid, shippingId, form);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1, 10);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());

    }
}