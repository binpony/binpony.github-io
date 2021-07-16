package com.hairui.boot.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalTime;
import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hairui.boot.config.DateJacksonConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

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

    //@JsonFormat(pattern = "HH:mm")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="HH:mm")
    //@JsonDeserialize(using = DateJsonDeserializer.class)

    //@DateTimeFormat(pattern = "HH:mm")

    //@JsonFormat(pattern = "HH:mm")
    //@DateTimeFormat(pattern = "HH:mm")


    @JsonDeserialize(using = DateJacksonConverter.class)
    private Date sBegin;

    //@JsonFormat(pattern = "HH:mm")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="HH:mm")
    //@JsonDeserialize(using = DateJsonDeserializer.class)

    //@DateTimeFormat(pattern = "HH:mm")

    //@JsonFormat(pattern = "HH:mm")
    //@DateTimeFormat(pattern = "HH:mm")
    @JsonDeserialize(using = DateJacksonConverter.class)
    private Date sEnd;

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


}
