package com.dytian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dytian.entity.User_account;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户通行证 服务类
 * </p>
 *
 * @author dytian
 * @since 2018-09-05
 */
public interface IUser_accountService extends IService<User_account> {


    List<User_account> getAllAccounts();

    List<User_account> getAllAccountsPage();



    void deleteById(Integer id);






}
