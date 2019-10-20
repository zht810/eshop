package com.zht.eshop.inventory.request.impl;

import com.zht.eshop.inventory.request.RequestAsyncProcessService;
import com.zht.eshop.inventory.request.RequestQueue;
import com.zht.eshop.inventory.request.RequstInterface;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class RequestAsyncProcessServiceImpl implements RequestAsyncProcessService {
    @Override
    public void process(RequstInterface requst) {
        RequestQueue requestQueue = RequestQueue.getInstance();
        Map<Integer, Boolean> flagMap = requestQueue.getFlagMap();
        Integer productId = requst.getProductId();

        Boolean flag = flagMap.get(productId);
        if (requst instanceof ProductInventoryDBUpdateRequest) {
            flagMap.put(productId, true);
        } else if (requst instanceof ProductInventoryCacheRefreshRequest) {
            if (flag == null) {
                flagMap.put(productId, false);
            } else if (flag != null && flag) {
                flagMap.put(productId, false);
            } else if (flag != null && !flag) {
                return;
            }
        }

        LinkedBlockingQueue<RequstInterface> queue = getRoutingQueue(productId);
        try {
            queue.put(requst);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private LinkedBlockingQueue<RequstInterface> getRoutingQueue(Integer productId) {
        RequestQueue requestQueue = RequestQueue.getInstance();

        // 先获取productId的hash值
        String key = String.valueOf(productId);
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        // 对hash值取模，将hash值路由到指定的内存队列中，比如内存队列大小8
        // 用内存队列的数量对hash值取模之后，结果一定是在0~7之间
        // 所以任何一个商品id都会被固定路由到同样的一个内存队列中去的
        int index = (requestQueue.getQueueSize() - 1) & hash;

        System.out.println("===========RequestAsyncProcessServiceImpl日志===========: 路由内存队列，商品id=" + productId + "," +
                " 队列索引=" + index);

        return requestQueue.getRequestQueue(index);
    }
}
