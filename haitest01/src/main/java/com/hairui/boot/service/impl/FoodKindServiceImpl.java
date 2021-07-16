package com.hairui.boot.service.impl;

import com.hairui.boot.entity.FoodKind;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.mapper.FoodKindMapper;
import com.hairui.boot.service.FoodKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-05-23
 */
@Service
public class FoodKindServiceImpl extends ServiceImpl<FoodKindMapper, FoodKind> implements FoodKindService {
    @Autowired
    private FoodKindMapper foodKindMapper;

    @Override
    public Result<Void> insertFoodKind(FoodKind foodKind) {
        try {
            this.foodKindMapper.insert(foodKind);
            return Result.<Void>builder().status(200).msg("增加食品种类成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Void>builder().status(500).msg("增加食品种类失败").build();

        }
    }

    @Override
    public PageResults<FoodKind> findFoodKind() {
        try {
            List<FoodKind> foodKinds = this.foodKindMapper.selectList(null);
            return PageResults.<FoodKind>builder().status(200).msg("查询食品种类成功")
                               .data(foodKinds).build();
        } catch (Exception e) {
            return PageResults.<FoodKind>builder().status(200).msg("查询食品种类成功").build();
        }
    }
}
