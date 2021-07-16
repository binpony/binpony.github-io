package com.hairui.boot.mapper;

import com.hairui.boot.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {

    //模糊查询
    public List<Order> fuzzyQueryOrder(Map<String,Object> params);

    //查询首页
    int IndexOrder(Map<String, Object> map);

}
