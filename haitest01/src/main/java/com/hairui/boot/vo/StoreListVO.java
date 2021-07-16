package com.hairui.boot.vo;

import lombok.Data;

import java.time.LocalTime;

@Data
public class StoreListVO {
    private Integer sId;

    private String sName;

    private String sAddress;

    private String sPhone;

    private String sIntroduce;

    private Integer sScore;

    private Integer sSales;

    private String cName;

    private String headPhoto;

    private Integer claId;
}
