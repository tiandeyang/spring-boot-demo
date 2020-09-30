package com.dytian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dytian.entity.User_account;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 用户通行证 Mapper 接口
 * </p>
 *
 * @author dytian
 * @since 2018-09-05
 */
public interface User_accountMapper extends BaseMapper<User_account> {


    List<User_account> getAllAccounts();

    int getMaxId();

    void updateId();

  //  List<User_account> getAllAccountsPage(Pagination pagination);

    void deleteById(Integer id);


 //   User_account selectUserByName(String user_name, String user_email);







}
