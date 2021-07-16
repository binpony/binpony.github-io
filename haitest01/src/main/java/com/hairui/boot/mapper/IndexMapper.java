package com.hairui.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hairui.boot.vo.IndexVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndexMapper extends BaseMapper<IndexVo> {
    //查询首页
    int selectUser(Map<String,Object> map);
    int selectAdmin(Map<String,Object> map);
    int selectOrder(Map<String,Object> map);
    //查询总数
    int selectAllUserCount();
    int selectAllAdminCount();
    int selectAllOrderCount();
}
