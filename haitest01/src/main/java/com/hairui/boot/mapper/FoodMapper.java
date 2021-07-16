package com.hairui.boot.mapper;

import com.hairui.boot.entity.Food;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hairui.boot.entity.FoodFormat;
import com.hairui.boot.vo.FoodInsertVo;
import com.hairui.boot.vo.FoodListVo;
import com.hairui.boot.vo.FoodUpdateVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-05-21
 */
@Repository
public interface FoodMapper extends BaseMapper<Food> {

    List<Food> findFoodByPage ();

//    @Select("select f.*, s.s_id, s.s_name, s.s_address " +
//            "from food f " +
//            "inner join store s " +
//            "on f.s_id = s.s_id ")
    //分页查询的新方法，写一个对应页面的vo层，再返回这个vo层中的数据
    List<FoodListVo> selectAllFood();
    List<FoodFormat> selectFormatByFId(Integer fid);

    //这个方法有bug
    FoodUpdateVo selectFoodById(Integer fId);

    //更新食品
    int updateFoodUpdateVo(FoodUpdateVo foodUpdateVo);
    int updateFoodFormatDeleted(FoodUpdateVo foodUpdateVo);
    int insertFoodFormat(FoodUpdateVo foodUpdateVo);

    //添加食品
    int insertFoodInsertVo(FoodInsertVo foodInsertVo);
    int insertFoodTrait(FoodInsertVo foodInsertVo);
    int insertFoodInsertVoFormat(FoodInsertVo foodInsertVo);

    //模糊查询food
    List<FoodListVo> fuzzyQueryFood(Map<String,Object> params);

    List<FoodListVo> selectFoodAndFormat();
}
