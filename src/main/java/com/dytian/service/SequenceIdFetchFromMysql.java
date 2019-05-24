package com.dytian.service;

import com.dytian.mapper.User_accountMapper;
import com.dytian.mapper.YuemeeSequMapper;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Classname SequenceIdFetchFromMysql
 * @Description TODO
 * @Date 2019/5/20 10:29
 * @Created by Administrator
 */
@Component
public class SequenceIdFetchFromMysql implements SequenceIdFetch {


    @Resource
    YuemeeSequMapper yuemeeSequMapper;

    @Override
    public long getId() {
       // yuemeeSequMapper.s
//        Record sub_ip = dao.fetch(TABLE, Cnd.where("sub_ip", "=", "192.168.22.10"));
//        int maxId = sub_ip.getInt("id");
////        int maxStep = maxId * STEP;
////        long max = (maxId + 1) * STEP;
//        Sql sql = Sqls.create("REPLACE INTO yuemee_sequ (sub_ip) VALUES ('192.168.22.10')");
//        dao.execute(sql);
//        return new IdOpjo(maxStep, max);
        return 0;
    }
}
