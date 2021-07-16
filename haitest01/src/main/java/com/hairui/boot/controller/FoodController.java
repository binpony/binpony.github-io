package com.hairui.boot.controller;


import com.hairui.boot.entity.Food;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.service.FoodService;
import com.hairui.boot.vo.FoodInsertVo;
import com.hairui.boot.vo.FoodListVo;
import com.hairui.boot.vo.FoodUpdateVo;
import com.hairui.boot.vo.StoreListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-05-21
 */
@RestController
@Api(tags = "食品接口")
@RequestMapping("//food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @ApiOperation(value = "查询食品页面",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询食品" +
                    ",接口：http://120.78.238.34:8080/food/findFoodByPage" +
                    ",传参：pageNum:  和   pageSize:")
    @PostMapping("/findFoodByPage")
    public PageResults<FoodListVo> findFoodByPage(@RequestBody Map<String,Object> params){
        return this.foodService.findFoodByPage(params);
    }

    @ApiOperation(value = "食品页面的删除功能",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来删除食品" +
                    ",接口：http://120.78.238.34:8080/food//deleteFood/{id}" +
                    ",在路径后加入id参数，即直接在路径添加数字id")
    @DeleteMapping("/deleteFood/{id}")
    public Result<Void> deleteFood(@PathVariable("id") Integer id){
        return this.foodService.deleteFoodByID(id);
    }

    @ApiOperation(value = "根据id查找食品",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;编辑食品界面的重写," +
                    "接口：http://120.78.238.34:8080/food/selectFoodById/{fId}," +
                    "在路径后加入id参数，即直接在路径添加数字id")
    @GetMapping("/selectFoodById/{fId}")
    public Result<FoodUpdateVo> selectFoodById(@PathVariable("fId") Integer fId){
        return this.foodService.selectFoodById(fId);
    }

    @ApiOperation(value = "食品页面的编辑功能",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来编辑食品," +
                    "接口：http://120.78.238.34:8080/food/updateFood" +
                    ",传参：fid(这个必传),fname,fdetail,fkind,fphoto," +
                    "还有一个数组foodFormats,数组中有ffName,ffPack,ffPrice")
    @PostMapping("/updateFood")
    public Result<FoodUpdateVo> updateFood(@RequestBody FoodUpdateVo foodUpdateVo){
        return this.foodService.updateFood(foodUpdateVo);
    }

    @ApiOperation(value = "增加食品",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;增加食品" +
                    ",接口：http://120.78.238.34:8080/food/insertFood," +
                    ",传参：fname,fdetail,fkind,fphoto,factivity,sid(商店的id,必传)" +
                    "数组1：foodTraits(特点)，数组中有ftId(传数字1代表新品，2代表招牌)," +
                    "数组2：foodFormats(规格)，ffName,ffPack,ffPrice")
    @PostMapping("/insertFood")
    public Result<FoodInsertVo> insertFood(@RequestBody FoodInsertVo foodInsertVo){
        return this.foodService.insertFood(foodInsertVo);
    }

    @ApiOperation(value = "模糊查询食品页面(即搜索)",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询食品" +
                    ",接口：http://120.78.238.34:8080/food/fuzzyQueryFood" +
                    ",传参：分页参数：pageNum:和pageSize:," +
                    "查询food的参数：fName")
    @PostMapping("/fuzzyQueryFood")
    public PageResults<FoodListVo> fuzzyQueryFood(@RequestBody Map<String,Object> params){
        return this.foodService.fuzzyQueryFood(params);
    }







}

