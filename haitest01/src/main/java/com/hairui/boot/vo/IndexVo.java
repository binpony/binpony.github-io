package com.hairui.boot.vo;

import lombok.Data;

import java.util.Date;

@Data
public class IndexVo {
    private int userCount;
    private int orderCount;
    private int AdminCount;
    private Date time;
}
