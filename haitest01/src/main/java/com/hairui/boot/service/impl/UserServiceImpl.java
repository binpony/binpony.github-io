package com.hairui.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.entity.User;
import com.hairui.boot.mapper.UserMapper;
import com.hairui.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hairui.boot.vo.UserPieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
     private UserMapper userMapper;

    @Override
    public Result<User> getUserById(Integer uId) {
        try {
            User user = this.userMapper.selectById(uId);
            return Result.<User>builder().status(200).msg("查询用户成功").data(user).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<User>builder().status(500).msg("查询用户失败").build();
        }
    }

    @Override
    public Result<Void> insertUser(User user) {
        try {
            int insert = this.userMapper.insert(user);
            return Result.<Void>builder().status(200).msg("查询用户成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Void>builder().status(500).msg("查询用户失败").build();
        }
    }

    @Override
    public PageResults<User> getUser(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }

            PageHelper.startPage(pageNum, pageSize, true);
            List<User> users = this.userMapper.selectList(null);
            PageInfo<User> userPageInfo = new PageInfo<>(users);

            return PageResults.<User>builder().status(200).msg("查询用户成功")
                    .data(userPageInfo.getList()).count(userPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<User>builder().status(500).msg("查询用户失败")
                    .build();
        }
    }

    @Override
    public PageResults<User> fuzzyQueryUser(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");

            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<User> users = this.userMapper.fuzzyQueryUser(params);
            PageInfo<User> userPageInfo = new PageInfo<>(users);
            return PageResults.<User>builder().status(200).msg("模糊查询用户成功")
                    .data(userPageInfo.getList()).count(userPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<User>builder().status(500).msg("模糊查询用户失败")
                    .build();
        }
    }

    //按照前端要求传数据
    @Override
    public PageResults<Map<String, Integer>> selectUserPie() {
        try {
            List<UserPieVo> userPieVos = this.userMapper.selectPieCount();
            Map<String, Integer> map = new HashMap<>();
            String name = "qita";
            //名字为其他的迭代器
            int i = 0;
            List<Map<String, Integer>> list = new ArrayList<>();
            for (UserPieVo userPieVo : userPieVos) {
                String uAddress = userPieVo.getUAddress();
                if (uAddress.equals("上海")){
                    String s = "shanghai";
                    Integer value = userPieVo.getValue();
                    map.put(s,value);
                }else if (uAddress.equals("北京")){
                    String s = "beijing";
                    Integer value = userPieVo.getValue();
                    map.put(s,value);
                }else if (uAddress.equals("深圳")){
                    String s = "shenzhen";
                    Integer value = userPieVo.getValue();
                    map.put(s,value);
                }else if (uAddress.equals("杭州")){
                    String s = "hangzhou";
                    Integer value = userPieVo.getValue();
                    map.put(s,value);
                }else {
                    Integer value = userPieVo.getValue();
                    i = i + value;
                }
            }
            map.put(name, i);
            list.add(map);

            return PageResults.<Map<String, Integer>>builder().status(200).msg("查询饼状图成功").data(list).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Map<String, Integer>>builder().status(500).msg("查询饼状图失败").build();

        }


    }




}
