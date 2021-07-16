package com.hairui.boot.mapper;

import com.hairui.boot.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hairui.boot.entity.StoreAndClassify;
import com.hairui.boot.vo.StoreInsertVo;
import com.hairui.boot.vo.StoreListVO;
import com.hairui.boot.vo.StoreVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
@Repository
public interface StoreMapper extends BaseMapper<Store> {

    //List<StoreAndClassify> findStore();

    List<StoreListVO> findStoreByPage();

    StoreVO findStoreById(Integer sId);

    //int updateStore(StoreVO storeVO);

    //添加商品
    int insertStoreInsertVo(StoreInsertVo storeInsertVo);
    int insertStoreTrait(StoreInsertVo storeInsertVo);
    int insertStoreDiscount(StoreInsertVo storeInsertVo);

    //模糊查询商店
    List<StoreListVO> fuzzyQueryStore(Map<String,Object> params);



}
