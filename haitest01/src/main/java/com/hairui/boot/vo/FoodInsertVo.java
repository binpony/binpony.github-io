package com.hairui.boot.vo;

import com.hairui.boot.entity.FoodFormat;
import com.hairui.boot.entity.FoodTrait;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.naming.Name;
import java.util.List;

@Data
@ApiModel("FoodInsertVo")
public class FoodInsertVo {

    @ApiModelProperty(name = "fId")
    private Integer fId;

    private String fKind;

    private String fName;

    private String fActivity;

    private String fDetail;

    private String fPhoto;

    private Integer sId;

    private List<FoodTrait> foodTraits;

    private List<FoodFormat> foodFormats;

}
