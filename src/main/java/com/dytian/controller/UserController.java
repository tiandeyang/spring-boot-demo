package com.dytian.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Levin
 * @since 2018/6/28 0028
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String get() {
        return "get.....";
    }

    /**
     * RequiresRoles 是所需角色 包含 AND 和 OR 两种
     * RequiresPermissions 是所需权限 包含 AND 和 OR 两种
     *
     * @return msg
     */
    @RequiresRoles(value = {"admin", "test"}, logical = Logical.OR)
    //@RequiresPermissions(value = {"user:list", "user:query"}, logical = Logical.OR)
    @GetMapping("/query")
    public String query() {
        return "query.....";
    }

    @GetMapping("/find")
    public String find() {
      //  return "find.....";
            jdbcTemplate.execute(new ConnectionCallback<Object>() {
                @Override
                public Object doInConnection(Connection connection) throws SQLException, DataAccessException {
                    PreparedStatement preparedStatement = connection.prepareStatement("select * from user_account limit 1");
                    boolean execute = preparedStatement.execute();

                    return null;
                }
            });

    return null;
    }


    @Autowired
    JdbcTemplate jdbcTemplate;


}