package com.hairui.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hairui.boot.entity.Order;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.mapper.OrderMapper;
import com.hairui.boot.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageResults<Order> getOrder(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<Order> orders = this.orderMapper.selectList(null);
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);

            return PageResults.<Order>builder().status(200).msg("查询订单成功").data(orderPageInfo.getList())
                    .count(orderPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Order>builder().status(500).msg("查询订单失败").build();
        }
    }

    @Override
    public PageResults<Order> fuzzyQueryOrder(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<Order> orders = this.orderMapper.fuzzyQueryOrder(params);
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
            return PageResults.<Order>builder().status(200).msg("模糊查询订单成功").data(orderPageInfo.getList())
                    .count(orderPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Order>builder().status(500).msg("模糊查询订单成功").build();
        }
    }
}
