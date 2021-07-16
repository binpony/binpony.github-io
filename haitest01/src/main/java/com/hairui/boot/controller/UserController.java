package com.hairui.boot.controller;


import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.entity.User;
import com.hairui.boot.service.UserService;
import com.hairui.boot.vo.UserPieVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
@RestController
@Api(tags = "用户接口")
@RequestMapping("//user")
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "查询USER页面",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询user" +
                    ",接口：http://120.78.238.34:8080/user/getUser" +
                    "传参：分页参数：pageNum:(这是当前页码)和pageSize:(这是一页要展示的数量)")
    @PostMapping("/getUser")
    public PageResults<User> getUser(@RequestBody Map<String, Object> params) {
        return this.userService.getUser(params);
    }
    @ApiOperation(value = "根据id查询用户",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来根据id查询user" +
                    ",接口：http://120.78.238.34:8080/user/getUser/getUserByID/{uId}" +
                    ",在路径后加入id参数，即直接在路径添加数字id")
    @GetMapping("/getUserByID/{uId}")
    public Result<User> getUserByID(@PathVariable("uId") Integer uId) {
        return userService.getUserById(uId);
    }


 /*   @PostMapping("/insertUser")
    public Result<Void> insertUser(@RequestBody User user) {
        return this.userService.insertUser(user);
    }*/

    @ApiOperation(value = "模糊查询USER",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来模糊查询user," +
                    "接口：http://120.78.238.34:8080/user/fuzzyQueryUser" +
                    ",传参：分页参数：pageNum:和pageSize:," +
                    "查询user的参数：uName和uAddress")
    @PostMapping("/fuzzyQueryUser")
    public PageResults<User> fuzzyQueryUser(@RequestBody Map<String, Object> params){
        return this.userService.fuzzyQueryUser(params);
    }

    @ApiOperation(value = "查询USER饼状图",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来模糊查询user" +
                    ",接口：http://120.78.238.34:8080/user/selectUserPie")
    @GetMapping("/selectUserPie")
    public PageResults<Map<String, Integer>> selectUserPie(){
        return this.userService.selectUserPie();
    }
}

