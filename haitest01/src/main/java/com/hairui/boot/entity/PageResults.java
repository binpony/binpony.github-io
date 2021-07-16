package com.hairui.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResults<T> implements Serializable {

    private Integer status;
    private String msg;
    private List<T> data;
    private Long count;

}
