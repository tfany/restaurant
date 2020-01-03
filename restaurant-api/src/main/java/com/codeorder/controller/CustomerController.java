package com.codeorder.controller;
import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;
import com.codeorder.service.DishService;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping
public class CustomerController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private DishService dishService;

    @GetMapping("/customer")
    public CommonResult<Object> showHomePage() {
        Shop shop = shopService.queryShop();
        List<Dish> dishList = dishService.queryAllDish();
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
}
