package com.hairui.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hairui.boot.entity.Food;
import com.hairui.boot.entity.FoodFormat;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.mapper.FoodFormatMapper;
import com.hairui.boot.mapper.FoodMapper;
import com.hairui.boot.service.FoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hairui.boot.vo.FoodInsertVo;
import com.hairui.boot.vo.FoodListVo;
import com.hairui.boot.vo.FoodUpdateVo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-05-21
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private FoodFormatMapper foodFormatMapper;

    @Transactional
    @Override
    public PageResults<FoodListVo> findFoodByPage(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<FoodListVo> foodByPage = this.foodMapper.selectAllFood();
            PageInfo<FoodListVo> foodPageInfo = new PageInfo<>(foodByPage);
            return PageResults.<FoodListVo>builder().status(200).msg("查询食品成功").data(foodPageInfo.getList())
                    .count(foodPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<FoodListVo>builder().status(500).msg("查询食品失败")
                    .build();
        }
    }

    @Transactional
    @Override
    public Result<Void> deleteFoodByID(Integer id) {

        try {
            int i = this.foodMapper.deleteById(id);
            return Result.<Void>builder().status(200).msg("删除用户成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Void>builder().status(500).msg("删除用户失败").build();
        }
    }

    @Override
    public PageResults<FoodListVo> selectAllFood(Map<String, Object> params) {
        this.foodMapper.selectAllFood();
        return null;
    }

    @Override
    public Result<FoodUpdateVo> selectFoodById(Integer fId) {
        try {
            FoodUpdateVo foodUpdateVo = new FoodUpdateVo();
            Food food = this.foodMapper.selectById(fId);
            //第一个就是要被copy的值
            BeanUtils.copyProperties(foodUpdateVo,food);
            /*QueryWrapper<FoodFormat> foodFormatQueryWrapper = new QueryWrapper<>();
            QueryWrapper<FoodFormat> fid = foodFormatQueryWrapper.eq("f_id", fId);
            List<FoodFormat> foodFormats = this.foodFormatMapper.selectList(fid);*/

            List<FoodFormat> foodFormats = this.foodMapper.selectFormatByFId(fId);
            foodUpdateVo.setFoodFormats(foodFormats);
            //第一个就是要被copy的值
            //BeanUtils.copyProperties(foodUpdateVo,food);
            return Result.<FoodUpdateVo>builder().status(200).msg("查询食品成功").data(foodUpdateVo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<FoodUpdateVo>builder().status(500).msg("查询食品失败").build();
        }
    }

    @Transactional
    @Override
    public Result<FoodUpdateVo> updateFood(FoodUpdateVo foodUpdateVo) {
        try {
            this.foodMapper.updateFoodUpdateVo(foodUpdateVo);
            this.foodMapper.updateFoodFormatDeleted(foodUpdateVo);
            this.foodMapper.insertFoodFormat(foodUpdateVo);
            return Result.<FoodUpdateVo>builder().status(200).msg("更新食品成功").data(foodUpdateVo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<FoodUpdateVo>builder().status(500).msg("更新食品失败").build();

        }

    }

    @Transactional
    @Override
    public Result<FoodInsertVo> insertFood(FoodInsertVo foodInsertVo) {
        try {
            this.foodMapper.insertFoodInsertVo(foodInsertVo);
            this.foodMapper.insertFoodTrait(foodInsertVo);
            this.foodMapper.insertFoodInsertVoFormat(foodInsertVo);
            return Result.<FoodInsertVo>builder().status(200)
                    .msg("增加食品成功").data(foodInsertVo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<FoodInsertVo>builder().status(500)
                    .msg("增加食品失败").build();
        }
    }

    @Override
    public PageResults<FoodListVo> fuzzyQueryFood(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<FoodListVo> foodByPage = this.foodMapper.fuzzyQueryFood(params);
            PageInfo<FoodListVo> foodPageInfo = new PageInfo<>(foodByPage);
            return PageResults.<FoodListVo>builder().status(200).msg("模糊查询食品成功").data(foodPageInfo.getList())
                    .count(foodPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<FoodListVo>builder().status(500).msg("模糊查询食品失败").build();
        }

    }


}
