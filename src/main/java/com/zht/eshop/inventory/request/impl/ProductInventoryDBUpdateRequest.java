package com.zht.eshop.inventory.request.impl;

import com.zht.eshop.inventory.model.ProductInventoryModel;
import com.zht.eshop.inventory.request.RequstInterface;
import com.zht.eshop.inventory.service.ProductInventoryService;

public class ProductInventoryDBUpdateRequest implements RequstInterface {
    /**
     * 商品库存
     */
    private ProductInventoryModel productInventory;
    /**
     * 商品库存Service
     */
    private ProductInventoryService productInventoryService;

    public ProductInventoryDBUpdateRequest(ProductInventoryModel productInventory, ProductInventoryService productInventoryService) {
        this.productInventory = productInventory;
        this.productInventoryService = productInventoryService;
    }

    @Override
    public void process() {
        System.out.println("===========ProductInventoryDBUpdateRequest日志===========: 数据库更新请求开始执行，商品id="
                + productInventory.getProductId() + ", 商品库存数量=" + productInventory.getInventoryCnt());
        //删除缓存
        productInventoryService.removeProductInventoryCache(productInventory);
        //修改数据库库存
        productInventoryService.updateById(productInventory);
    }

    @Override
    public Integer getProductId() {
        return this.productInventory.getProductId();
    }
}
