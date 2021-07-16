package com.hairui.boot.service;

import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hairui.boot.vo.UserPieVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
public interface UserService extends IService<User> {

    public Result<User> getUserById(Integer uId);

    Result<Void> insertUser(User user);

    PageResults<User> getUser(Map<String, Object> params);

    //模糊查询
    PageResults<User> fuzzyQueryUser(Map<String, Object> params);

    PageResults<Map<String, Integer>> selectUserPie();
}
