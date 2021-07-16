package com.hairui.boot.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2021-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FoodFormat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ff_id", type = IdType.AUTO)
    private Integer ffId;

    private String ffName;

    private Integer ffPack;

    private Integer ffPrice;

    @TableField(value = "`f_id`")
    private Integer fId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;


}
