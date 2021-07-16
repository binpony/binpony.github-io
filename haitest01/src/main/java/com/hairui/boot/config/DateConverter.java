package com.hairui.boot.config;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*@Component
public class DateConverter implements Converter<String, Date> {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String value) {
        *//**
         * 可对value进行正则匹配，支持日期、时间等多种类型转换
         * @param value
         * @return
         *//*
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            return formatter.parse(value);
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
    }
}*/


