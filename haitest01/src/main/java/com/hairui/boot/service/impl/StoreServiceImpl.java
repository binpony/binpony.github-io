package com.hairui.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hairui.boot.entity.*;
import com.hairui.boot.mapper.FoodMapper;
import com.hairui.boot.mapper.StoreMapper;
import com.hairui.boot.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hairui.boot.vo.StoreInsertVo;
import com.hairui.boot.vo.StoreListVO;
import com.hairui.boot.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private FoodMapper foodMapper;


    @Override
    public PageResults<StoreListVO> findStorePage(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<StoreListVO> store = this.storeMapper.findStoreByPage();
            PageInfo<StoreListVO> storeListVOPageInfo = new PageInfo<>(store);
            return PageResults.<StoreListVO>builder().status(200).msg("查询商店页面成功")
                    .data(storeListVOPageInfo.getList())
                    .count(storeListVOPageInfo.getTotal()).build();
        } catch (Exception e) {
            return PageResults.<StoreListVO>builder().status(500).msg("查询商店页面失败").build();
        }
    }

    @Override
    public Result<Store> findStoreById(Integer sId) {
        try {
            Store storeById = this.storeMapper.selectById(sId);
            return Result.<Store>builder().status(200).msg("根据id查询成功").data(storeById).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Store>builder().status(500).msg("根据id查询失败").build();
        }
    }

    /*@Override
    public Result<StoreVO> updateStoreVo(StoreVO storeVO) {
        try {
            int i = this.storeMapper.updateStore(storeVO);
            return Result.<StoreVO>builder().status(200).msg("更新用户成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<StoreVO>builder().status(500).msg("更新用户失败").build();
        }
    }*/

    @Transactional
    @Override
    public Result<Store> updateStore(Store store) {
        try {
            int update = this.storeMapper.updateById(store);
            return Result.<Store>builder().status(200).msg("更新用户成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Store>builder().status(500).msg("更新用户失败").build();
        }

    }

    @Transactional
    @Override
    public Result<StoreInsertVo> insertStoreInsertVo(StoreInsertVo storeInsertVo) {
        try {
            this.storeMapper.insertStoreInsertVo(storeInsertVo);
            this.storeMapper.insertStoreTrait(storeInsertVo);
            this.storeMapper.insertStoreDiscount(storeInsertVo);
            return Result.<StoreInsertVo>builder().status(200).msg("插入用户成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<StoreInsertVo>builder().status(500).msg("插入用户失败").build();
        }
    }

    @Transactional
    @Override
    public Result<Void> deleteStore(Integer sId) {
        try {
            this.storeMapper.deleteById(sId);
            QueryWrapper<Food> foodQueryWrapper = new QueryWrapper<>();
            QueryWrapper<Food> s_id = foodQueryWrapper.eq("s_id", sId);
            this.foodMapper.delete(s_id);
            return Result.<Void>builder().status(200).msg("删除商店和食品成功").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.<Void>builder().status(500).msg("删除商店和对应的食品失败").build();
        }
    }

    @Override
    public PageResults<StoreListVO> fuzzyQueryStore(Map<String, Object> params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            if (pageNum == null || pageNum <= 0 || pageSize == null || pageSize <= 0) {
                pageNum = 1;
                pageSize = 5;
            }
            PageHelper.startPage(pageNum, pageSize, true);
            List<StoreListVO> store = this.storeMapper.fuzzyQueryStore(params);
            PageInfo<StoreListVO> storeListVOPageInfo = new PageInfo<>(store);
            return PageResults.<StoreListVO>builder().status(200).msg("模糊查询商店页面成功")
                    .data(storeListVOPageInfo.getList())
                    .count(storeListVOPageInfo.getTotal()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<StoreListVO>builder().status(500).msg("模糊查询商店页面失败").build();
        }

    }
}
