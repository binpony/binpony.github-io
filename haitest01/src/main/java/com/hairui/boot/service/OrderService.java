package com.hairui.boot.service;

import com.hairui.boot.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
public interface OrderService extends IService<Order> {

    public PageResults<Order> getOrder(Map<String, Object> params);

    //模糊查询
    PageResults<Order> fuzzyQueryOrder(Map<String, Object> params);
}
