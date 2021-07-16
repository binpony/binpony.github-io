package com.hairui.boot.mapper;

import com.hairui.boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hairui.boot.vo.UserPieVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    //模糊查询用户
    List<User> fuzzyQueryUser(Map<String,Object> params);

    //饼状图
    List<UserPieVo> selectPieCount();

    //用map查询饼状图
    //Map<String, Integer> selectPie();
}
