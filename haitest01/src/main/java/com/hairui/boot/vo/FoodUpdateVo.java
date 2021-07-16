package com.hairui.boot.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.hairui.boot.entity.Food;
import com.hairui.boot.entity.FoodFormat;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@Data
public class FoodUpdateVo  {
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
    //食品规格
    private List<FoodFormat> foodFormats;
}
