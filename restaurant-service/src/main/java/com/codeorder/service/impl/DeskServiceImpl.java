package com.codeorder.service.impl;

import com.codeorder.mapper.DeskMapper;
import com.codeorder.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskMapper deskMapper;

    @Override
    public Integer insertDesk(Integer deskNum, String url) {
        return deskMapper.insertDesk(deskNum,url);
    }

}
