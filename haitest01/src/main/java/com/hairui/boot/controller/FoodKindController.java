package com.hairui.boot.controller;


import com.hairui.boot.entity.FoodKind;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.service.FoodKindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-05-23
 */
@RestController
@Api(tags = "食品种类接口")
@RequestMapping("//foodKind")
public class FoodKindController {
    @Autowired
    private FoodKindService foodKindService;
    @ApiOperation(value = "添加食品种类",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;添加食品种类," +
                    "接口：http://120.78.238.34:8080/foodKind/insertFoodKind," +
                    "传参：fkName，fkDetail")
    @PostMapping("/insertFoodKind")
    public Result<Void> insertFoodKind(@RequestBody FoodKind foodKind){
        return this.foodKindService.insertFoodKind(foodKind);
    }

    @ApiOperation(value = "查找食品种类",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;查找食品种类," +
                    "接口：http://120.78.238.34:8080/foodKind//findFoodKind")
    @GetMapping("/findFoodKind")
    public PageResults<FoodKind> findFoodKind(){
        return this.foodKindService.findFoodKind();
    }
}

