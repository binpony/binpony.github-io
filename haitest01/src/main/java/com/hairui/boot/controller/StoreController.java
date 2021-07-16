package com.hairui.boot.controller;


import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.entity.Store;
import com.hairui.boot.entity.StoreAndClassify;
import com.hairui.boot.service.StoreService;
import com.hairui.boot.vo.StoreInsertVo;
import com.hairui.boot.vo.StoreListVO;
import com.hairui.boot.vo.StoreVO;
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
 * @since 2021-05-20
 */
@RestController
@Api(tags = "商店页面")
@RequestMapping("//store")
public class StoreController {
    @Autowired
    private StoreService storeService;


    @ApiOperation(value = "查询商店页面",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来查询商店" +
                    ",接口：http://120.78.238.34:8080/store/getStoreByPage" +
                    "传参：分页参数：pageNum:(这是当前页码)和pageSize:(这是一页要展示的数量)")
    @PostMapping("/getStoreByPage")
    public PageResults<StoreListVO> getStoreByPage(@RequestBody Map<String,Object> params){
        return this.storeService.findStorePage(params);
    }
    @ApiOperation(value = "根据id查询商店",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;编辑功能中实现内容重写" +
                    ",接口：http://120.78.238.34:8080/store/getStoreById/{sId}," +
                    ",在路径后加入id参数，即直接添加数字id")
    @GetMapping("/getStoreById/{sId}")
    public Result<Store> getStoreById(@PathVariable("sId") Integer sId){
        return this.storeService.findStoreById(sId);
    }

    @ApiOperation(value = "修改商店",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;编辑功能," +
                    "接口：http://120.78.238.34:8080/store/updateStore" +
                    ",传参：sid ,sname,saddress,sintroduce,sphone,claId(商店分类，传数字id即可" +
                    "1为异国料理，2为快餐便当，3为小吃夜宵，4为果蔬生鲜)" +
                    "headPhoto")
    @PostMapping("/updateStore")
    public Result<Store> updateStore(@RequestBody Store store){
        return this.storeService.updateStore(store);
    }


    @ApiOperation(value = "增加商店",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;增加功能," +
                    "接口：http://120.78.238.34:8080/store/insertStore," +
                    "传参：sname,saddress,sphone,sintroduce,sslogan,claId(店铺分类id)," +
                    "数组1：traits(店铺特点)：tid(1代表品牌保证，2代表蜂鸟专送，3新开店铺，4外卖保，" +
                    "5准时达，6开发票)," +
                    "scost,sprice,sbegin,send,headPhoto,allowPhoto,buyPhoto," +
                    "数组2:discounts(优惠活动)：dname，dtitle，ddetail")
    @PostMapping("/insertStore")
    public Result<StoreInsertVo> insertStoreInsertVo(@RequestBody StoreInsertVo storeInsertVo){
        return this.storeService.insertStoreInsertVo(storeInsertVo);
    }

    @ApiOperation(value = "删除商店",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;删除商店和对应的食品" +
                    ",接口：http://120.78.238.34:8080/store/deleteStore/{sId}" +
                    ",在路径后加入id参数，即直接添加数字id")
    @DeleteMapping("/deleteStore/{sId}")
    public Result<Void> deleteStore(@PathVariable("sId") Integer sId){
        return this.storeService.deleteStore(sId);

    }

    @ApiOperation(value = "模糊查询商店（即搜索）",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;删除商店和对应的食品," +
                    "接口：http://120.78.238.34:8080/store/fuzzyQueryStore," +
                    "传参：分页参数：pageNum:和pageSize:," +
                    "查询store的参数：sName,sPhone,cName(店铺分类名称)")
    @PostMapping("/fuzzyQueryStore")
    public PageResults<StoreListVO> fuzzyQueryStore(@RequestBody Map<String,Object> params){
        return this.storeService.fuzzyQueryStore(params);
    }

}

