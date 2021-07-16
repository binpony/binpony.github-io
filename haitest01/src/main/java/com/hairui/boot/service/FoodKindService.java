package com.hairui.boot.service;

import com.hairui.boot.entity.FoodKind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-05-23
 */
public interface FoodKindService extends IService<FoodKind> {

    public Result<Void> insertFoodKind(FoodKind foodKind);
    public PageResults<FoodKind> findFoodKind();
}
