
package com.codeorder.controller;

import com.codeorder.pojo.Shop;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import com.codeorder.utils.QRCodeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;


@RestController
@RequestMapping("manager")
public class QRCodeController {
    @Autowired
    private ShopService shopService;

    /**
     *
     * @param tableNum
     * @return
     */
    @PostMapping("/getQRcode")
    public CommonResult<URL> createQRCode(@RequestParam("tableNum") int tableNum) {
        Shop shop=shopService.shopInfo();
        if(shop.getUrl()!=null){
            boolean flag=QRCodeUtil.createQRCode(tableNum,shop.getUrl());
            if(flag) {
                try {
                    URL url=new URL(shop.getUrl());
                    return CommonResult.success(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            return CommonResult.failed("二维码生成失败");
        }
        return CommonResult.failed("请输入店铺的URL");
    }
}
