
package com.codeorder.controller;

import com.codeorder.utils.CommonResult;
import com.codeorder.utils.QRCodeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;


@RestController
@RequestMapping("manager")
public class QRCodeController {

    /**
     *
     * @param tableNum
     * @return
     */
    @PostMapping("/getQRcode")
    public CommonResult<URL> createQRCode(@Param("tableNum") int tableNum) {
        boolean flag=QRCodeUtil.createQRCode(tableNum,"http://www.baidu.com");
        if(flag) {
            try {
                URL url=new URL("http://www.baidu.com");
                return CommonResult.success(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.failed("二维码生成失败");
    }
}
