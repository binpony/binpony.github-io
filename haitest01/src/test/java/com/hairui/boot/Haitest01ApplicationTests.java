package com.hairui.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hairui.boot.entity.*;
import com.hairui.boot.mapper.*;
import com.hairui.boot.service.AdminService;
import com.hairui.boot.service.FoodService;
import com.hairui.boot.service.IndexService;
import com.hairui.boot.service.StoreService;
import com.hairui.boot.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;


@Slf4j
@SpringBootTest
class Haitest01ApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private FoodFormatMapper foodFormatMapper;
    @Autowired
    private StoreService storeService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private FoodService foodService;
    @Autowired
    private IndexMapper indexMapper;

    @Test
    public void insert(){
        User user = this.userMapper.selectById(3);
        this.userMapper.updateById(user);
    }

    @Test
    public void findStore(){
        Store store = this.storeMapper.selectById(1);
        System.out.println(store);

    }

 /*   @Test
    public void findStoreAndCla(){
        List<StoreAndClassify> store = this.storeMapper.findStore();
        System.out.println(store);
    }*/

   /* @Test
    public void findFood(){
        List<Food> foodByPage = this.foodMapper.findFoodByPage();
        System.out.println(foodByPage);
    }*/

    @Test
    public void deleteFood(){
        int i = this.foodMapper.deleteById(2);
        System.out.println(i);
    }


    @Test
    public void mazebinsb(){
        this.foodMapper.selectAllFood().forEach(System.out::println);
    }



    @Test
    public void findStoreById(){
        StoreVO storeById = this.storeMapper.findStoreById(1);
        System.out.println(storeById);
    }

    @Test
    public void findByPage(){
        this.storeMapper.findStoreByPage().forEach(System.out::println);
    }

    //增加商店
    @Test
    public void insertStore(){
        StoreInsertVo storeInsertVo = new StoreInsertVo();
        //添加中间表store_to_trait中特点的id
        Trait trait = new Trait();
        trait.setTId(1);
        Trait trait1 = new Trait();
        trait1.setTId(2);
        //把特点的id传入storeInsertVo中的List<Trait>中
        List<Trait> traits = new ArrayList<>();
        traits.add(trait);
        traits.add(trait1);
        //添加discount表中的数据
        Discount discount = new Discount();
        discount.setDTitle("特");
        discount.setDName("优惠大酬宾");
        discount.setDDetail("好");
        Discount discount1 = new Discount();
        discount1.setDTitle("新");
        discount1.setDName("新用户立减");
        discount1.setDDetail("xin");
        List<Discount> discounts = new ArrayList<>();
        discounts.add(discount);
        discounts.add(discount1);

        //设置storeInsertVo类中的属性
        storeInsertVo.setClaId(2);
        storeInsertVo.setTraits(traits);
        storeInsertVo.setDiscounts(discounts);

        this.storeMapper.insertStoreInsertVo(storeInsertVo);
        this.storeMapper.insertStoreTrait(storeInsertVo);
        this.storeMapper.insertStoreDiscount(storeInsertVo);
        //storeInsertVo.setTraits();
    }

    //根据id查找食品
    @Test
    public void findFoodById() throws InvocationTargetException, IllegalAccessException {
        FoodUpdateVo foodUpdateVo = new FoodUpdateVo();
        Food food = this.foodMapper.selectById(2);
        log.info("food = {}", food);
        //第一个就是要被copy的值
        BeanUtils.copyProperties(foodUpdateVo, food);
        QueryWrapper<FoodFormat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("f_id", food.getFId());
        List<FoodFormat> foodFormats = this.foodFormatMapper.selectList(queryWrapper);
        foodUpdateVo.setFoodFormats(foodFormats);
        log.info("foodUpdateVo = {}", foodUpdateVo);
    }

    @Test
    public void findFoodById2(){
        Food food = this.foodMapper.selectById(2);
        System.out.println(food);
    }

    @Test
    public void updateFood(){
        Food food = new Food();
        food.setFId(1);
        food.setFDetail("hahaha");
        this.foodMapper.updateById(food);
    }

    @Test
    public void updateFood2(){
        FoodFormat foodFormat = new FoodFormat();
        List<FoodFormat> foodFormats = new ArrayList<>();
        foodFormats.add(foodFormat);
        FoodUpdateVo foodUpdateVo = new FoodUpdateVo();
        foodUpdateVo.setFId(1);
        foodUpdateVo.setFName("马德");
        foodUpdateVo.setFoodFormats(foodFormats);
        this.foodMapper.updateFoodUpdateVo(foodUpdateVo);
        this.foodMapper.insertFoodFormat(foodUpdateVo);


    }

    @Test
    public void deleteFormat(){
        FoodUpdateVo foodUpdateVo = new FoodUpdateVo();
        foodUpdateVo.setFId(1);
        this.foodMapper.updateFoodFormatDeleted(foodUpdateVo);
    }

    @Test
    public void insertFormat(){
        FoodFormat foodFormat = new FoodFormat();
        foodFormat.setFfName("da");
        foodFormat.setFfPack(2);
        foodFormat.setFfPrice(2);
        List<FoodFormat> foodFormats = new ArrayList<>();
        foodFormats.add(foodFormat);
        FoodUpdateVo foodUpdateVo = new FoodUpdateVo();
        foodUpdateVo.setFId(2);
        foodUpdateVo.setFoodFormats(foodFormats);
        this.foodMapper.insertFoodFormat(foodUpdateVo);
    }

    //删除商店
    @Test
    public void deleteStore(){
        System.out.println(this.storeService.deleteStore(1));
    }

    @Test
    //添加食品
    public void insertFood(){
        FoodInsertVo foodInsertVo = new FoodInsertVo();
        foodInsertVo.setSId(2);
        FoodTrait foodTrait = new FoodTrait();
        foodTrait.setFtId(1);
        FoodFormat foodFormat = new FoodFormat();
        foodFormat.setFfName("大");

        List<FoodTrait> foodTraits = new ArrayList<>();
        foodTraits.add(foodTrait);
        List<FoodFormat> foodFormats = new ArrayList<>();
        foodFormats.add(foodFormat);

        foodInsertVo.setFoodTraits(foodTraits);
        foodInsertVo.setFoodFormats(foodFormats);
        this.foodMapper.insertFoodInsertVo(foodInsertVo);
        this.foodMapper.insertFoodTrait(foodInsertVo);
        this.foodMapper.insertFoodInsertVoFormat(foodInsertVo);
    }

    //登录方法
    @Test
    public void login(){
        Admin admin = new Admin();
        admin.setAName("123");
        admin.setAPassword("123");
        Result<Admin> login = this.adminService.login(admin);
        System.out.println(login);
    }

    //模糊查询user
    @Test
    public void fuzzyQueryUser(){
      /*  User user = new User();
        user.setUName("1");
        user.setUAddress("重");*/
        Map<String, Object> params = new HashMap<>();
        params.put("uName", "123");
        //params.put("uAddress","重");
        List<User> users = this.userMapper.fuzzyQueryUser(params);
        users.forEach(System.out::println);
    }

    //模糊查询food
    @Test
    public void fuzzyQueryFood(){
        FoodListVo foodListVo = new FoodListVo();
        foodListVo.setFName("str");
        Map<String, Object> params = new HashMap<>();
        params.put("fName","str");
        List<FoodListVo> foodListVos = this.foodMapper.fuzzyQueryFood(params);
        foodListVos.forEach(System.out::println);
    }

    //模糊查询商店
    @Test
    public void fuzzyQueryStore(){
        StoreListVO storeListVO = new StoreListVO();
        storeListVO.setSName("1");
        //storeListVO.setSPhone("str");
        storeListVO.setCName("快");
        Map<String, Object> params = new HashMap<>();
        //params.put("sName", "1");
        params.put("cName", "快");
        List<StoreListVO> storeListVOS = this.storeMapper.fuzzyQueryStore(params);
        storeListVOS.forEach(System.out::println);
    }

    //模糊查询订单
    @Test
    public void fuzzyQueryOrder(){
        Order order = new Order();
        order.setCreateTime(LocalDateTime.of(2019, 11, 30, 15, 16, 17));
        order.setUpdateTime(LocalDateTime.now());
        Map<String, Object> params = new HashMap<>();
        params.put("createTime",LocalDateTime.of(2019, 11, 30, 15, 16, 17));
        params.put("updateTime", LocalDateTime.now());
        List<Order> orders = this.orderMapper.fuzzyQueryOrder(params);
        orders.forEach(System.out::println);
    }

    @Test
    public void fuzzyQueryFoodService(){

        Map<String, Object> params = new HashMap<>();
        params.put("fName","str");
        PageResults<FoodListVo> foodListVoPageResults = this.foodService.fuzzyQueryFood(params);
        System.out.println(foodListVoPageResults);
    }

    //饼状图查询
    @Test
    public void PieCount(){
        List<UserPieVo> userPieVos = this.userMapper.selectPieCount();
        Map<String, Integer> map = new HashMap<>();
        String name = "qita";
        //名字为其他的迭代器
        int i = 0;
        List<Map<String, Integer>> list = new ArrayList<>();
        for (UserPieVo userPieVo : userPieVos) {
            String uAddress = userPieVo.getUAddress();
            if (uAddress.equals("上海")){
                String s = "shanghai";
                Integer value = userPieVo.getValue();
                map.put(s,value);
            }else if (uAddress.equals("北京")){
                String s = "beijing";
                Integer value = userPieVo.getValue();
                map.put(s,value);
            }else if (uAddress.equals("深圳")){
                String s = "shenzhen";
                Integer value = userPieVo.getValue();
                map.put(s,value);
            }else if (uAddress.equals("杭州")){
                String s = "hangzhou";
                Integer value = userPieVo.getValue();
                map.put(s,value);
            }else {
                Integer value = userPieVo.getValue();
                i = i + value;
            }
        }
        map.put(name, i);
        list.add(map);
        list.forEach(System.out::println);
    }

    @Test
    public void testIndexOrder(){
        Map<String, Object> map = new HashMap<>();
        //获得当天的时间
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String endTime = format.format(date)+" 0:0:0";
        //获得前一天的时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        String beginTime =  format.format(date)+" 0:0:0";
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        //获取数量
        int userCount = this.indexMapper.selectUser(map);
        int adminCount = this.indexMapper.selectAdmin(map);
        int orderCount = this.indexMapper.selectOrder(map);
        log.info("userCount={},adminCount={},orderCount={},beginTime={},endTime={}",userCount,adminCount,orderCount,beginTime,endTime);
        System.out.println("2021-05-26 0:0:0"+"2021-05-27 0:0:0"+"2021‐05‐27 0:0:0");
    }

    //测试获得前一天/后一天
    @Test
    public void lateDate(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-0);
        date = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date)+" 0:0:0";
        log.info("date={}",s);
    }

    @Test
    public void updateStore(){
        Store store = new Store();
        store.setSId(1);
        store.setClaId(2);
        int i = this.storeMapper.updateById(store);
        System.out.println(i);
       /* Result<Store> storeResult = this.storeService.updateStore(store);
        System.out.println(storeResult);*/
    }


    @Autowired
    private IndexService indexService;
    @Test
    public void getAdminCountByPrams(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date)+" 0:0:0";
        log.info("beginTime={}",s);
        calendar.setTime(date);
        calendar.add(Calendar.DATE,+1);
        date = calendar.getTime();
        String s1 = format.format(date)+" 0:0:0";
        log.info("endTime={}",s1);
        System.out.println(this.indexService.getAdminCount(0));

    }


    @Test
    public void getAllFood(){
        //List<FoodListVo> foodListVos = this.foodMapper.selectAllFood();
        //foodListVos.forEach(System.out::println);
        FoodListVo foodListVo = new FoodListVo();
        List<FoodFormat> foodFormats = this.foodMapper.selectFormatByFId(1);
        foodListVo.setFoodFormats(foodFormats);
        foodFormats.forEach(System.out::println);
        System.out.println(foodListVo.toString());
    }

    @Autowired
    private FoodKindMapper foodKindMapper;
    @Test
    public void getFoodKind(){
        List<FoodKind> foodKinds = this.foodKindMapper.selectList(null);
        foodKinds.forEach(System.out::println);
    }










}


