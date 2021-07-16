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
 * @since 2021-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FoodKind implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fk_id", type = IdType.AUTO)
    private Integer fkId;

    private String fkName;

    private String fkDetail;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer isDeleted;


}
