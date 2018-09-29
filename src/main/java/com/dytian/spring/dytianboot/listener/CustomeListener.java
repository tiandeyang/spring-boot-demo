package com.dytian.spring.dytianboot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class CustomeListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
      //  log.info("listener  requestDestroyed....");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
     //   log.info("listener   requestInitialized....");
    }
}
