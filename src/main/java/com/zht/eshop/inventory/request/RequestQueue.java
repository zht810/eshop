package com.zht.eshop.inventory.request;

import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {
    private List<LinkedBlockingQueue<RequstInterface>> requstQueueList = new ArrayList<>();
    /**
     * 标识位map
     */
    private Map<Integer, Boolean> flagMap = new ConcurrentHashMap<Integer, Boolean>();

    /**
     * jvm的机制去保证多线程并发安全
     * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     * @return
     */
    public static RequestQueue getInstance() {
        return Singleton.getInstance();
    }

    private static class Singleton {
        private static RequestQueue instance;
        static {
            instance = new RequestQueue();
        }
       public static RequestQueue getInstance() {
            return instance;
        }
    }

    /**
     * 添加一个队列
     */
    public Boolean addQueue(LinkedBlockingQueue<RequstInterface> requstIModel) {
        return requstQueueList.add(requstIModel);
    }
    /**
     * 取出一个队列
     */
    public LinkedBlockingQueue<RequstInterface> getRequestQueue(int index) {
        return requstQueueList.get(index);
    }

    /**
     * 队列的大小
     */
    public Integer getQueueSize() {
        return requstQueueList.size();
    }

    public Map<Integer, Boolean> getFlagMap() {
        return flagMap;
    }
}
