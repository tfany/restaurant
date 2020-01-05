package com.codeorder.controller;

import com.codeorder.pojo.Category;
import com.codeorder.pojo.OrderListDto;
import com.codeorder.service.CategoryService;
import com.codeorder.service.OrderService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;
import com.codeorder.service.DishService;
import com.codeorder.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private DishService dishService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/showDish")
    public CommonResult<Object> showHomePage() {
        Shop shop = shopService.shopInfo();
        List<Dish> dishList = dishService.queryAllDishNoPage();
        if (dishList.size() < 1) {
            return CommonResult.failed();
        }
        if (shop == null) {
            return CommonResult.failed();
        }
        Map<Shop, List<Dish>> map = new HashMap<>();
        map.put(shop, dishList);
        return CommonResult.success(map);
    }


    @PostMapping("/placeOrder")
    @ResponseBody
    /**
     * 顾客下单
     */
    public CommonResult<Object> placeOrder(@RequestBody OrderListDto orderListDto) {
        return CommonResult.success(orderService.placeOrder(orderListDto.getDetailList(), orderListDto.getTableNum()));
    }

    @GetMapping("/show")
    public CommonResult<Object> showDish(){
        int count = -1;
        List<Category> categoryList = categoryService.queryAllCategory();
        Map<String,Object> map =new HashMap();
        List<Map> goodsMapList = new ArrayList();
        for(Category category : categoryList){
            List<Dish> dishList = dishService.queryDishByCategoryId(category.getId());
            Map<String,Object> goodsMap =new HashMap();
            goodsMap.put("name",category.getName());
            goodsMap.put("type",count);
            goodsMap.put("foods",dishList);
            goodsMapList.add(goodsMap);
        }
        map.put("goods",goodsMapList);
        return CommonResult.success(map);
    }



}
