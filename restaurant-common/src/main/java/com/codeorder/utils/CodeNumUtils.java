package com.codeorder.utils;

/**
 * @author fanzhang
 * @date 2020/1/2 - 11:38
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class CodeNumUtils {
    /**
     * 根据时间生成订单号 年月日时分秒+5个随机数
     */
    public String getCodeNumber() {
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSS");
        String subjectno = allTime.format(new Date())+random.nextInt(10);
        return subjectno+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
    }
}
