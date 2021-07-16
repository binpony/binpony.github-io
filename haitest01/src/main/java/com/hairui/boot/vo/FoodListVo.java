package com.hairui.boot.vo;

import com.hairui.boot.entity.Food;
import com.hairui.boot.entity.FoodFormat;
import lombok.Data;

import java.util.List;

@Data
public class FoodListVo {

    private Integer fId;

    private String fName;

    private String fDetail;

    private String fKind;

    private Integer fScore;

    private Integer fSales;

    private Integer sId;

    private String sName;

    private String sAddress;

    private String fPhoto;
    //食品规格
    private List<FoodFormat> foodFormats;

}
