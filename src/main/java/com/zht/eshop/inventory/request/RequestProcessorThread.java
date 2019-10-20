package com.zht.eshop.inventory.request;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestProcessorThread implements Callable<Boolean> {
    private LinkedBlockingQueue<RequstInterface> queue;

    public RequestProcessorThread (LinkedBlockingQueue<RequstInterface> queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            while (true) {
                System.out.println("===========RequestProcessorThread日志===========: 工作线程处理请求，" +
                        "线程id=" + Thread.currentThread().getId());

                RequstInterface requstInterface = queue.take();
                System.out.println("===========RequestProcessorThread日志===========: 工作线程处理请求，商品id=" + requstInterface.getProductId());

                requstInterface.process(); //处理请求
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(3000);
        }
        return true;
    }
}
