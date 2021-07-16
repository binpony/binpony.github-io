package com.hairui.boot.service;

import com.hairui.boot.entity.Food;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.vo.FoodInsertVo;
import com.hairui.boot.vo.FoodListVo;
import com.hairui.boot.vo.FoodUpdateVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-05-21
 */
public interface FoodService extends IService<Food> {
    public PageResults<FoodListVo> findFoodByPage(Map<String,Object> params);

    public Result<Void> deleteFoodByID(Integer id);

    public PageResults<FoodListVo> selectAllFood(Map<String,Object> params);

    //根据id查询编辑页面的food对象
    public Result<FoodUpdateVo> selectFoodById(Integer id);

    //编辑食品
    public Result<FoodUpdateVo> updateFood(FoodUpdateVo foodUpdateVo);

    //增加食品
    public Result<FoodInsertVo> insertFood(FoodInsertVo foodInsertVo);

    //模糊查询
    PageResults<FoodListVo> fuzzyQueryFood(Map<String, Object> params);
}
