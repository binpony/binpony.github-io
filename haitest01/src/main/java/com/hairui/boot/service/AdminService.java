package com.hairui.boot.service;

import com.hairui.boot.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
public interface AdminService extends IService<Admin> {

    public PageResults<Admin> getAdminByPage(Map<String, Object> params);

    public Result<Admin> login(Admin admin);
    //显示管理员信息
    public Result<Admin> adminMsg();

    //更换管理员头像
    public Result<Admin> updatePhoto(Admin admin);
}
