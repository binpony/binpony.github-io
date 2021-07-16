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
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "f_id", type = IdType.AUTO)
    private Integer fId;

    private String fKind;

    private String fName;

    private String fActivity;

    private String fDetail;

    private String fPhoto;

    private Integer sId;

    private Integer fScore;

    private Integer fSales;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;

    //写的困难的sql语句
    //private Store store;


}
