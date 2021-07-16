package com.hairui.boot.service;

import com.hairui.boot.entity.PageResults;

import java.util.Map;

public interface IndexService  {

    PageResults<Map<String,Object>> getIndexCount();

    PageResults<Map<String,Object>> getAdminCount(Integer day);
    PageResults<Map<String,Object>> getUserCount(Integer day);
    PageResults<Map<String,Object>> getOrderCount(Integer day);
}
