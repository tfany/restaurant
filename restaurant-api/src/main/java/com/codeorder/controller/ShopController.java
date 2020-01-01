package com.codeorder.controller;

import com.codeorder.pojo.Shop;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manager")
public class ShopController {
    @Autowired
    ShopService shopService;

    @GetMapping("/shop")
    public CommonResult<Shop> queryShop(){
        Shop shop=shopService.queryShop();
        if(shop!=null){
            return CommonResult.success(shop);
        }
        return CommonResult.failed("尚未添加店铺信息");
    }
}
