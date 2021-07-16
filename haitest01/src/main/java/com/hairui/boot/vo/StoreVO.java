package com.hairui.boot.vo;

import lombok.Data;

import java.time.LocalTime;

@Data
public class StoreVO {
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

    private String cName;



}
