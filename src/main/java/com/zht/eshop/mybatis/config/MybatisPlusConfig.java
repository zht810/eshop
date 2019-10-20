package com.zht.eshop.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * 分页拦截器
 */
public class MybatisPlusConfig {
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
