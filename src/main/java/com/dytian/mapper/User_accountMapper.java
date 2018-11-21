package com.dytian.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.dytian.entity.User_account;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


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

    List<User_account> getAllAccountsPage(Pagination pagination);

    void deleteById(Integer id);


    User_account selectUserByName(String user_name, String user_email);







}
