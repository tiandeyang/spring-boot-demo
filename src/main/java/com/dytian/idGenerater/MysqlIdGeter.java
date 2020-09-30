package com.dytian.idGenerater;

import com.dytian.mapper.User_accountMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MysqlIdGeter implements IdGeter {

    @Resource
    User_accountMapper user_accountMapper;


    @Override
    public Integer getId() {
        int maxId = user_accountMapper.getMaxId();
        user_accountMapper.updateId();
        return maxId;
    }
}
