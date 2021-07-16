package com.hairui.boot.controller;


import com.hairui.boot.entity.Order;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
@RestController
@Api(tags = "订单接口")
@RequestMapping("//order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @ApiOperation(value = "查询订单页面",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询订单," +
                    "接口：http://120.78.238.34:8080/order/getOrder" +
                    ",传参：pageNum: 和 pageSize:")
    @PostMapping("/getOrder")
    public PageResults getOrder(@RequestBody Map<String,Object> params){
        return this.orderService.getOrder(params);
    }

    @ApiOperation(value = "模糊查询订单页面（即搜索）",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询订单," +
                    "接口：http://120.78.238.34:8080/order/fuzzyQueryOrder," +
                    ",查询order的参数：createTime(查询开始时间)，updateTime(查询结束时间)")
    @PostMapping("/fuzzyQueryOrder")
    public PageResults<Order> fuzzyQueryOrder(@RequestBody Map<String,Object> params){
        return this.orderService.fuzzyQueryOrder(params);
    }

}

