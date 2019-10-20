package com.zht.eshop.inventory.service;

import com.zht.eshop.inventory.model.ProductInventoryModel;

/**
 * 商品库存Service接口
 * @author Administrator
 *
 */
public interface ProductInventoryService extends BaseServiceCRUD<ProductInventoryModel>{


	/**
	 * 删除Redis中的商品库存的缓存
	 * @param productInventory 商品库存
	 */
	void removeProductInventoryCache(ProductInventoryModel productInventory);

	/**
	 * 设置商品库存的缓存
	 * @param productInventory 商品库存
	 */
	void setProductInventoryCache(ProductInventoryModel productInventory);
	
	/**
	 * 获取商品库存的缓存
	 * @param productId
	 * @return
	 */
	ProductInventoryModel getProductInventoryCache(Integer productId);
	
}
