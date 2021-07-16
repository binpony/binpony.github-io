package com.hairui.boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class StoreAndClassify {
    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    private String sName;

    private String sAddress;

    private String sPhone;

    private String sIntroduce;

    private String sSlogan;

    private Integer claId;

    private Integer sCost;

    private Integer sPrice;

    private LocalTime sBegin;

    private LocalTime sEnd;

    private String headPhoto;

    private String buyPhoto;

    private String allowPhoto;

    private Integer sScore;

    private Integer sSales;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer isDeleted;

    private Classify classify;



}
