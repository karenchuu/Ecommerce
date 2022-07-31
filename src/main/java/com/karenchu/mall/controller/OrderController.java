package com.karenchu.mall.controller;

import com.github.pagehelper.PageInfo;
import com.karenchu.mall.consts.MallConst;
import com.karenchu.mall.form.OrderCreateForm;
import com.karenchu.mall.pojo.User;
import com.karenchu.mall.service.IOrderService;
import com.karenchu.mall.vo.OrderVo;
import com.karenchu.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 訂單模塊 Controller
 * Created by Karen on 2022/5/12.
 */
@Api(tags = "OrderController", description = "訂單模塊")
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation(value = "建立訂單")
    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                      HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.create(user.getId(), form.getShippingId());
    }

    @ApiOperation(value = "獲取訂單列表")
    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                       HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.list(user.getId(), pageNum, pageSize);
    }

    @ApiOperation(value = "獲取訂單詳情")
    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo,
                                     HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.detail(user.getId(), orderNo);
    }

    @ApiOperation(value = "取消訂單")
    @PutMapping("/orders/{orderNo}")
    public ResponseVo cancel(@PathVariable Long orderNo,
                             HttpSession session) {
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.cancel(user.getId(), orderNo);
    }
}
