package com.hairui.boot.service.impl;

import com.hairui.boot.entity.PageResults;
import com.hairui.boot.mapper.IndexMapper;
import com.hairui.boot.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author pjh
 * @date 2021/5/27
 */
@Slf4j
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public PageResults<Map<String,Object>> getIndexCount() {
        try {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            List<Map<String, Object>> list = new ArrayList<>();
            //获取当天的时间27号
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //String endTime = format.format(date)+" 0:0:0";
            for (int i = 0; i < 6; i++) {
                if (i == 0){
                    //获得当天时间
                    String beginTime = format.format(date)+" 0:0:0";
                    //i=0时获得后一天的时间
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE,+1);
                    date = calendar.getTime();
                    String endTime =  format.format(date)+" 0:0:0";
                    map.put("beginTime",beginTime);
                    map.put("endTime",endTime);
                    //获取数量
                    int userCount = this.indexMapper.selectUser(map);
                    int adminCount = this.indexMapper.selectAdmin(map);
                    int orderCount = this.indexMapper.selectOrder(map);
                    //把数量放入map中，下面再讲这个map放入list集合中
                    params.put("userCount"+"-"+i,userCount);
                    params.put("adminCount"+"-"+i,adminCount);
                    params.put("orderCount"+"-"+i,orderCount);
                    //把这个date对象复位，方便下一步操作
                    calendar.add(Calendar.DATE,-1);
                    date = calendar.getTime();
                }
                //获得当天之前的数量
                else {
                    //

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE,-(i-1));
                    date = calendar.getTime();
                    String endTime =  format.format(date)+" 0:0:0";

                    //获取开始时间，但要先复位
                    calendar.add(Calendar.DATE,+(i-1));
                    date = calendar.getTime();
                    calendar.add(Calendar.DATE,-i);
                    date = calendar.getTime();
                    String beginTime = format.format(date)+" 0:0:0";
                    map.put("beginTime",beginTime);
                    map.put("endTime",endTime);
                    //获取数量
                    int userCount = this.indexMapper.selectUser(map);
                    int adminCount = this.indexMapper.selectAdmin(map);
                    int orderCount = this.indexMapper.selectOrder(map);
                    //把数量放入map中，下面再讲这个map放入list集合中
                    params.put("userCount"+"-"+i,userCount);
                    params.put("adminCount"+"-"+i,adminCount);
                    params.put("orderCount"+"-"+i,orderCount);
                    calendar.add(Calendar.DATE,+i);
                    date = calendar.getTime();
                }
            }
            int allUserCount = this.indexMapper.selectAllUserCount();
            int allAdminCount = this.indexMapper.selectAllAdminCount();
            int allOrderCount = this.indexMapper.selectAllOrderCount();
            params.put("allUserCount", allUserCount);
            params.put("allAdminCount", allAdminCount);
            params.put("allOrderCount", allOrderCount);
            list.add(params);
            return PageResults.<Map<String, Object>>builder().status(200).msg("查询首页成功").data(list).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Map<String, Object>>builder().status(500).msg("查询首页失败").build();
        }
    }

    @Override
    public PageResults<Map<String,Object>> getAdminCount(Integer day) {
        try {
            Map<String, Object> map = new HashMap<>();
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            //获取开始时间
            calendar.setTime(date);
            calendar.add(Calendar.DATE,-day);
            date = calendar.getTime();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String beginTime = format.format(date)+" 0:0:0";
            //获取结束时间
            calendar.setTime(date);
            calendar.add(Calendar.DATE,+1);
            date = calendar.getTime();
            String endTime = format.format(date)+" 0:0:0";
            map.put("beginTime",beginTime);
            map.put("endTime",endTime);
            log.info("beginTime={},endTime={}",beginTime,endTime);
            int i = this.indexMapper.selectAdmin(map);
            Map<String, Object> params = new HashMap<>();
            params.put("count", i);
            List<Map<String, Object>> list = new ArrayList<>();
            list.add(params);
            return PageResults.<Map<String, Object>>builder().status(200).msg("查询管理员数量成功").data(list).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Map<String, Object>>builder().status(500).msg("查询管理员数量失败").build();
        }
    }

    @Override
    public PageResults<Map<String,Object>> getUserCount(Integer day) {
        try {
            Map<String, Object> map = new HashMap<>();
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            //获取开始时间
            calendar.setTime(date);
            calendar.add(Calendar.DATE,-day);
            date = calendar.getTime();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String beginTime = format.format(date)+" 0:0:0";
            //获取结束时间
            calendar.setTime(date);
            calendar.add(Calendar.DATE,+1);
            date = calendar.getTime();
            String endTime = format.format(date)+" 0:0:0";
            map.put("beginTime",beginTime);
            map.put("endTime",endTime);
            log.info("beginTime={},endTime={}",beginTime,endTime);
            int i = this.indexMapper.selectUser(map);
            Map<String, Object> params = new HashMap<>();
            params.put("count", i);
            List<Map<String, Object>> list = new ArrayList<>();
            list.add(params);
            return PageResults.<Map<String, Object>>builder().status(200).msg("查询user数量成功").data(list).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Map<String, Object>>builder().status(500).msg("查询user数量失败").build();

        }

    }

    @Override
    public PageResults<Map<String,Object>> getOrderCount(Integer day) {
        try {
            Map<String, Object> map = new HashMap<>();
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            //获取开始时间
            calendar.setTime(date);
            calendar.add(Calendar.DATE,-day);
            date = calendar.getTime();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String beginTime = format.format(date)+" 0:0:0";
            //获取结束时间
            calendar.setTime(date);
            calendar.add(Calendar.DATE,+1);
            date = calendar.getTime();
            String endTime = format.format(date)+" 0:0:0";
            map.put("beginTime",beginTime);
            map.put("endTime",endTime);
            log.info("beginTime={},endTime={}",beginTime,endTime);
            int i = this.indexMapper.selectOrder(map);
            Map<String, Object> params = new HashMap<>();
            params.put("count", i);
            List<Map<String, Object>> list = new ArrayList<>();
            list.add(params);
            return PageResults.<Map<String, Object>>builder().status(200).msg("查询order数量成功").data(list).build();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResults.<Map<String, Object>>builder().status(500).msg("查询order数量失败").build();

        }

    }
}
