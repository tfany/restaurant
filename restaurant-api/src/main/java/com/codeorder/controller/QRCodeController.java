
package com.codeorder.controller;

import com.codeorder.pojo.Shop;
import com.codeorder.service.DeskService;
import com.codeorder.service.ShopService;
import com.codeorder.utils.CommonResult;
import com.codeorder.utils.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("manager")
public class QRCodeController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private DeskService deskService;

    /**
     *
     * @param deskNum
     * @return
     */
    @PostMapping("/getQRcode")
    public CommonResult<Object> createQRCode(@RequestParam("deskNum") Integer deskNum) {
        Shop shop=shopService.shopInfo();
        if(shop.getUrl()!=null){
            String imageUrl=QRCodeUtil.createQRCode(deskNum,shop.getUrl(),shop.getImage());
            if(!imageUrl.equals(null)&&!imageUrl.equals("")) {
                try {
                    int result=deskService.insertDesk(deskNum,imageUrl);
                    if(result==1) {
                        String url=shop.getUrl()+"/"+deskNum;
                        Map<String,Object> map=new HashMap<>();
                        map.put("shopUrl",shop.getUrl());
                        map.put("imageUrl",imageUrl);
                        return CommonResult.success(map);
                    }
                    return CommonResult.failed("二维码存储失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return CommonResult.failed("二维码生成失败");
        }
        return CommonResult.failed("请输入店铺的URL");
    }

}
