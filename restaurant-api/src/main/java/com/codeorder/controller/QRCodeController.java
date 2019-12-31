
package com.codeorder.controller;

import com.codeorder.utils.CommonResult;
import com.codeorder.utils.QrCodeUtils;

import org.springframework.util.ResourceUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@RestController
@RequestMapping("manager")
public class QRCodeController {

    @RequestMapping("/getQRcode")
    public Comparable<String> qrcode(HttpServletRequest request, HttpServletResponse response) {
        try {
            QrCodeUtils qrCodeUtil=new QrCodeUtils();
            String  path= ResourceUtils.getURL("classpath:").getPath()+"/static/1.png";
                         return qrCodeUtil.createQRCode("http://localhost:8088/login",300,300,path);
        } catch (IOException e) {
             e.printStackTrace();
              return (Comparable<String>) CommonResult.failed("失败");
        }
    }
}
