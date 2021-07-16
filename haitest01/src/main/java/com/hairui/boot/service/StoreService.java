package com.hairui.boot.service;

import com.hairui.boot.entity.PageResults;
import com.hairui.boot.entity.Result;
import com.hairui.boot.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hairui.boot.entity.StoreAndClassify;
import com.hairui.boot.vo.StoreInsertVo;
import com.hairui.boot.vo.StoreListVO;
import com.hairui.boot.vo.StoreVO;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
public interface StoreService extends IService<Store> {

    public PageResults<StoreListVO> findStorePage(Map<String,Object> params);

    //根据id进行查询
    Result<Store> findStoreById(Integer sId);

    //Result<StoreVO> updateStoreVo(StoreVO storeVO);

    //编辑商店
    Result<Store> updateStore(Store store);

    //增加商店
    Result<StoreInsertVo> insertStoreInsertVo(StoreInsertVo storeInsertVo);

    public Result<Void> deleteStore(Integer sId);

    //模糊查询商店
    public PageResults<StoreListVO> fuzzyQueryStore(Map<String,Object> params);

}
