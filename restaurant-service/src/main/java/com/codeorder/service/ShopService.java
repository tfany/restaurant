package com.codeorder.service;

import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;

import java.util.List;

public interface ShopService {
    Shop shopInfo() ;
    int updateShop(Shop shop );

    Shop queryShop();

}
