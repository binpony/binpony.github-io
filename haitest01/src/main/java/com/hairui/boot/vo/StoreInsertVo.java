package com.hairui.boot.vo;

import com.hairui.boot.entity.Discount;
import com.hairui.boot.entity.Trait;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StoreInsertVo {
    private Integer sId;

    private String sName;

    private String sAddress;

    private String sPhone;

    private String sIntroduce;

    private String sSlogan;

    private Integer claId;

    private Integer sCost;

    private Integer sPrice;

    private Date sBegin;

    private Date sEnd;

    private String headPhoto;

    private String buyPhoto;

    private String allowPhoto;

    //店铺特点
    private List<Trait> traits;
    //优惠活动
    private List<Discount> discounts;


}
