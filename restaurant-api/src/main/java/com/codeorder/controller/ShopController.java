package com.codeorder.controller;
import com.codeorder.pojo.Shop;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import com.codeorder.utils.ImageUtil;
import com.codeorder.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("manager")
public class ShopController {
    @Autowired

    private ShopService shopService;

    @GetMapping("/shopInfo")
    public CommonResult<Object> shopInfo(){
        Shop shop=shopService.shopInfo();
        Map<String,Object> map = new HashMap();
        Map<String,Object> sellerMap = new HashMap();
        sellerMap.put("name",shop.getName());
        sellerMap.put("description","开发版 v0.0.1");
        sellerMap.put("bulletin",shop.getNotice());
        sellerMap.put("avatar","http://static.galileo.xiaojukeji.com/static/tms/seller_avatar_256px.jpg");
//        sellerMap.put("avatar",shop.getImage());
        sellerMap.put("minPrice",0.1);
        map.put("seller",sellerMap);
        return CommonResult.success(map);
    }

    @GetMapping("/shopInformation")
    public CommonResult<Object> shopInformation(){
        Shop shop=shopService.shopInfo();
        return CommonResult.success(shop);
    }
    @PostMapping("/updateShop")
    public CommonResult updateShop(@RequestBody Shop shop){
        int result = shopService.updateShop(shop);
        if(result!=0) return CommonResult.success(null);
        return CommonResult.failed("更新失败");
    }

    @PostMapping("/uploadShopImg")
    public  CommonResult upload(MultipartFile file){
        String dishPath= PathUtil.getShopImage();
        String path = ImageUtil.generateThumbnail(file, dishPath);
        return CommonResult.success(path);
    }


}
