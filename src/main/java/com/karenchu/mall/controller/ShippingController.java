package com.karenchu.mall.controller;

import com.karenchu.mall.consts.MallConst;
import com.karenchu.mall.form.ShippingForm;
import com.karenchu.mall.pojo.User;
import com.karenchu.mall.service.IShippingService;
import com.karenchu.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 收貨地址模塊 Controller
 * Created by Karen on 2022/5/10.
 */
@Api(tags = "ShippingController", description = "收貨地址模塊")
@RestController
@Slf4j
public class ShippingController {

    @Autowired
    private IShippingService shippingService;

    @ApiOperation(value = "添加地址")
    @PostMapping("/shippings")
    public ResponseVo add(@Valid @RequestBody ShippingForm form,
                          HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shippingService.add(user.getId(), form);
    }


    @ApiOperation(value = "刪除地址")
    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Integer shippingId,
                                     HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shippingService.delete(user.getId(), shippingId);
    }

    @ApiOperation(value = "更新地址")
    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Integer shippingId,
                                     @Valid @RequestBody ShippingForm shippingForm,
                                     HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shippingService.update(user.getId(), shippingId, shippingForm);
    }

    @ApiOperation(value = "取得收貨地址列表")
    @GetMapping("/shippings")
    public ResponseVo list(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                   HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return shippingService.list(user.getId(), pageNum, pageSize);
    }

}
