package com.hairui.boot.service.impl;

import com.hairui.boot.entity.FoodFormat;
import com.hairui.boot.mapper.FoodFormatMapper;
import com.hairui.boot.service.FoodFormatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-05-22
 */
@Service
public class FoodFormatServiceImpl extends ServiceImpl<FoodFormatMapper, FoodFormat> implements FoodFormatService {
    @Autowired
    FoodFormatMapper foodFormatMapper;

}
