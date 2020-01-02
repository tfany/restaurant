package com.codeorder.controller;
import com.codeorder.pojo.Shop;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("manager")
public class ShopController {
    @Autowired

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


}
