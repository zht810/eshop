package com.zht.eshop.listener;

import com.zht.eshop.inventory.request.RequestProcessorThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 初始化工作线程池和内存队列，并将线程和内存队列进行绑定 （第一次获取这个instance会进行初始化）
        RequestProcessorThreadPool instance = RequestProcessorThreadPool.getInstance();
        System.out.println("====初始化上下文====");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁上下文");

    }
}
