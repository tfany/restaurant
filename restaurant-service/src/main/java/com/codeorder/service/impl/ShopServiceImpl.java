package com.codeorder.service.impl;


import com.codeorder.mapper.DishMapper;
import com.codeorder.mapper.ShopMapper;
import com.codeorder.pojo.Dish;
import com.codeorder.pojo.Shop;
import com.codeorder.service.DishService;
import com.codeorder.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {


    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop shopInfo() {
        return shopMapper.selectAll().get(0);
    }
    @Override
    public int updateShop(Shop shop) {
        return shopMapper.updateByPrimaryKey(shop);
    }



    public Shop queryShop() {
        return shopMapper.queryShop();
    }
}
