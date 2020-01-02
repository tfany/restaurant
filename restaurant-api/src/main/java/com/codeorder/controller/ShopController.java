package com.codeorder.controller;

<<<<<<< HEAD
import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;
import com.codeorder.service.DishService;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import com.codeorder.pojo.Shop;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05

@RestController
@RequestMapping("manager")
public class ShopController {
    @Autowired
<<<<<<< HEAD
    private ShopService shopService;

    @GetMapping("/shopInfo")
    public CommonResult<Shop> shopInfo(){
        Shop shop=shopService.shopInfo();
        return CommonResult.success(shop);
    }
    @PostMapping("/updateShop")
    public CommonResult updateShop(@RequestParam Shop shop){
        int result = shopService.updateShop(shop);
        if(result==0) return CommonResult.success(null);
        return CommonResult.failed("更新失败");
    }


=======
    ShopService shopService;

    @GetMapping("/shop")
    public CommonResult<Shop> queryShop(){
        Shop shop=shopService.queryShop();
        if(shop!=null){
            return CommonResult.success(shop);
        }
        return CommonResult.failed("尚未添加店铺信息");
    }
>>>>>>> cccc4c4bcd8b991a8a3343f8b903fda8e4bfcb05
}
