package com.codeorder.service.impl;

import com.codeorder.mapper.ShopMapper;
import com.codeorder.pojo.Shop;
import com.codeorder.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public Shop queryShop() {
        return shopMapper.queryShop();
    }
}
