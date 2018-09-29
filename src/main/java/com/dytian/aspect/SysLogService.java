package com.dytian.aspect;


import lombok.extern.slf4j.Slf4j;
import org.nutz.json.Json;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SysLogService {

    public boolean save(SysLogBO sysLogBO){
        log.info(Json.toJson(sysLogBO));
        return true;
    }

}
