package com.hairui.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    //状态码 200-成功 100-失败
    private int status;

    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private T data;
}

