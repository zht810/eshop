package com.zht.eshop.inventory.request;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestProcessorThreadPool {
    private ExecutorService executorSeervice = Executors.newFixedThreadPool(10);

    private RequestProcessorThreadPool() {
        init();
    }

    public static RequestProcessorThreadPool getInstance () {
        return Singleton.getInstance();
    }

    private static class Singleton {
        private static RequestProcessorThreadPool instance;
        static {
            instance = new RequestProcessorThreadPool();
        }
        public static RequestProcessorThreadPool getInstance() {
            return instance;
        }
    }

    /**
     * 初始化10个内存队列，再用10个线程去处理这个10个队列中请求
     */
    private void init() {
        for(int i = 0; i < 10; i++) {
            LinkedBlockingQueue<RequstInterface> queue = new LinkedBlockingQueue<>(500);
            RequestQueue.getInstance().addQueue(queue); // 加入到总队列中

            executorSeervice.submit(new RequestProcessorThread(queue)); //一个线程池和一个队列进行绑定
        }
    }
}
