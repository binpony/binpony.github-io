package com.hairui.boot.controller;

import com.hairui.boot.entity.PageResults;
import com.hairui.boot.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("//index")
@Api(tags = "首页接口")
@Slf4j
public class IndexController {
    @Autowired
    private IndexService indexService;

//    @ApiOperation(value = "首页的数据的展示",
//            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;查询首页" +
//                    ",接口：http://120.78.238.34:8080/index/getCount")
//    @GetMapping("/getCount")
//    public PageResults<Map<String,Object>> getCount(){
//        return this.indexService.getIndexCount();
//    }

    @ApiOperation(value = "每天的管理员数量",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;查询首页" +
                    ",接口：http://120.78.238.34:8080/index//getAdmin/{day}")
    @GetMapping("/getAdmin/{day}")
    public PageResults<Map<String,Object>> getAdmin(@PathVariable Integer day){
        return this.indexService.getAdminCount(day);
    }

    @ApiOperation(value = "每天的User数量",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;查询首页" +
                    ",接口：http://120.78.238.34:8080/index//getUser/{day}")
    @GetMapping("/getUser/{day}")
    public PageResults<Map<String,Object>> getUser(@PathVariable Integer day){
        return this.indexService.getUserCount(day);
    }


    @ApiOperation(value = "每天的Order数量",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;查询首页" +
                    ",接口：http://120.78.238.34:8080/index//getOrder/{day}")
    @GetMapping("/getOrder/{day}")
    public PageResults<Map<String,Object>> getOrder(@PathVariable Integer day){
        return this.indexService.getOrderCount(day);
    }




}
