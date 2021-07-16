package com.hairui.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hairui.boot.entity.Admin;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.entity.User;
import com.hairui.boot.mapper.AdminMapper;
import com.hairui.boot.mapper.UserMapper;
import com.hairui.boot.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2021-05-19
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public PageResults<Admin> getAdminByPage(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0){
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum,pageSize,true);
            //先查询出全部结果
            List<Admin> admins = this.adminMapper.selectList(null);
            //再分页
            PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
            return PageResults.<Admin>builder().status(200).msg("查询管理员成功").data(adminPageInfo.getList())
                    .count(adminPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Admin>builder().status(500).msg("查询管理员失败").build();
        }
    }

    @Override
    public Result<Admin> login(Admin admin) {
        try {
            String aName = admin.getAName();
            String aPassword = admin.getAPassword();
            QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<Admin>();
            adminQueryWrapper.eq("a_name", aName);
            adminQueryWrapper.eq("a_password", aPassword);
            log.info("aName={}",aName);
            log.info("aPassword={}",aPassword);
            Admin admin1 = this.adminMapper.selectOne(adminQueryWrapper);
            log.info("admin1={}",admin1);
            if (admin1.getAName()!=null&&admin1.getAPassword()!=null){
                return Result.<Admin>builder().status(200).msg("登录成功").data(admin1).build();
            }
            return Result.<Admin>builder().status(500).msg("登录失败").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Admin>builder().status(500).msg("登录失败").build();
        }
    }

    @Override
    public Result<Admin> adminMsg() {
        try {
            Admin admin = this.adminMapper.selectById(3);
            return Result.<Admin>builder().status(200).msg("管理员信息成功").data(admin).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Admin>builder().status(500).msg("管理员信息失败").build();
        }
    }

    @Override
    public Result<Admin> updatePhoto(Admin admin) {
        try {
            int i = this.adminMapper.updateById(admin);
            return Result.<Admin>builder().status(200).msg("更新头像成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Admin>builder().status(500).msg("更新头像失败").build();
        }
    }
}
