package com.codeorder.service.impl;

import com.codeorder.mapper.DishMapper;
import com.codeorder.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Override
    public int deleteDish(Integer id) {
        return dishMapper.deleteDish(id);
    }
}
