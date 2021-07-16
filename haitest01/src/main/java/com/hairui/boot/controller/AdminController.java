package com.hairui.boot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hairui.boot.entity.Admin;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.service.AdminService;
import com.hairui.boot.util.FastDFSClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-05-17
 */
@RestController
@Api(tags = "管理员接口")
@Slf4j
@RequestMapping("//admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    FastDFSClientUtil fastDFSClientUtil;

    /*   @ApiOperation(value = "pageHelper分页",
               notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询")
       @GetMapping("/getAdmin")
       public PageResults getAdmin(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
           //true设置可以算出总的条数
           PageResults<Admin> pageResults = new PageResults<>();
           PageHelper.startPage(pn, 1, true);
           PageInfo<Admin> pageInfo = PageInfo.of(adminService.list());
           pageResults.setData(pageInfo.getList());
           pageResults.setCount(pageInfo.getTotal());
           return pageResults;
       }*/

    //@RequestBody要使用Post请求
    @ApiOperation(value = "pageHelper分页",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询管理员," +
                    "接口：http://120.78.238.34:8080/admin/getAdmin," +
                    "传参：pageNum:  和   pageSize:")
    @PostMapping("/getAdmin")
    public PageResults<Admin> getAdmin(@RequestBody Map<String, Object> params) {
        return this.adminService.getAdminByPage(params);
    }


 /*   @ApiOperation(value = "文件上传测试",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来测试")
    @PostMapping("/fileTest")
    public String fileTest(@RequestParam("photo") MultipartFile photo) throws IOException {
        if (!photo.isEmpty()) {
            log.info(fastDFSClientUtil.uploadFile(photo));
            return fastDFSClientUtil.uploadFile(photo);
        }
        return null;
    }*/

    @ApiOperation(value = "登录接口",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来登录，" +
                    "接口：http://120.78.238.34:8080/admin/login" )
    @PostMapping("/login")
    public Result<Admin> login(@RequestBody Admin admin,
                               HttpSession session) {
        Result<Admin> login = this.adminService.login(admin);
        Admin data = login.getData();
        if (data!=null){
            session.setAttribute("admin",data);
            Object admin1 = session.getAttribute("admin");
            log.info("admin==========={}",admin1);
        }
        return login;
        /*if (admin.getAName() != null && admin.getAPassword() != null){
            return Result.<Admin>builder().status(200).msg("登录成功").data(admin).build();
        }
        return Result.<Admin>builder().status(500).msg("登录失败").build();*/
    }

    @ApiOperation(value = "管理员设置接口",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来显示登录的管理员信息" +
                    ",接口：http://120.78.238.34:8080/admin/loginMsg")
    @GetMapping("/loginMsg")
    public Result<Admin> loginMsg(){
        return this.adminService.adminMsg();
    }
    /*public Result<Admin> loginMsg(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin!=null){
            return Result.<Admin>builder().status(200).msg("显示用户信息成功").data(admin).build();
        }
        return Result.<Admin>builder().status(500).msg("显示用户信息失败").build();
    }*/


    @ApiOperation(value = "管理员设置中更新头像接口",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来更新管理员的头像" +
                    ",接口：http://120.78.238.34:8080/admin/updatePhoto" +
                    ",传参：id:   和   aphoto: ")
    @PostMapping("/updatePhoto")
    public Result<Admin> updatePhoto(@RequestBody Admin admin){
        return this.adminService.updatePhoto(admin);
    }
}



