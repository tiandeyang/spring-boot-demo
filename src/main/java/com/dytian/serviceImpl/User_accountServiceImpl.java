package com.dytian.serviceImpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.dytian.entity.User_account;
import com.dytian.mapper.User_accountMapper;
import com.dytian.service.IUser_accountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户通行证 服务实现类
 * </p>
 *
 * @author dytian
 * @since 2018-09-05
 */
@Service
public class User_accountServiceImpl extends ServiceImpl<User_accountMapper, User_account> implements IUser_accountService {

    @Override
    public List<User_account> getAllAccounts() {
        return baseMapper.getAllAccounts();
    }


    @Override
    public List<User_account> getAllAccountsPage() {
     //   page.setRecords(baseMapper.getAllAccountsPage(page));
        List<User_account> allAccounts = baseMapper.getAllAccounts();
     //   PageInfo<User_account> objectPageInfo = new PageInfo<>(allAccounts);
        return allAccounts;
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }


}
