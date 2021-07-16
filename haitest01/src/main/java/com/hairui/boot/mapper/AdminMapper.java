package com.hairui.boot.mapper;

import com.hairui.boot.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
//使用这个注解不会报红
@Repository
public interface AdminMapper extends BaseMapper<Admin> {


}
