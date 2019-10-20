package com.zht.eshop.inventory.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zht.eshop.inventory.mapper.ProductInventoryMapper;
import com.zht.eshop.inventory.model.ProductInventoryModel;
import com.zht.eshop.inventory.service.ProductInventoryService;
import com.zht.eshop.redis.config.RedisKeyManage;
import com.zht.eshop.redis.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service("productInventoryService")
public class ProductInventoryServiceImpl implements ProductInventoryService{

	@Resource
	private ProductInventoryMapper productInventoryMapper;

    @Autowired
    private RedisUtil redisUtil;

	@Override
	public void removeProductInventoryCache(ProductInventoryModel productInventory) {
		String key = RedisKeyManage.productInventoryKey + productInventory.getProductId();
		redisUtil.del(key);
		System.out.println("===========ProductInventoryServiceImpl日志===========: 已删除redis中的缓存，key=" + key);
	}

	@Override
	public void setProductInventoryCache(ProductInventoryModel productInventory) {
		String key = RedisKeyManage.productInventoryKey + productInventory.getProductId();
		redisUtil.set(key, productInventory.getInventoryCnt());
		System.out.println("===========ProductInventoryServiceImpl日志===========: 已更新商品库存的缓存，商品id="
				+ productInventory.getProductId() + ", 商品库存数量="
				+ productInventory.getInventoryCnt() + ", key=" + key);
	}

	@Override
	public ProductInventoryModel getProductInventoryCache(Integer productId) {
		String key = RedisKeyManage.productInventoryKey + productId;
		ProductInventoryModel productInventoryModel = new ProductInventoryModel();
		Object objCnt = redisUtil.get(key);
		if (objCnt != null) {
			productInventoryModel.setInventoryCnt(((Integer) objCnt).longValue());
			productInventoryModel.setProductId(productId);
			return productInventoryModel;
		}
		return null;
	}

	@Override
	public int insert(ProductInventoryModel entity) {
		return productInventoryMapper.insert(entity);
	}

	@Override
	public int deleteById(Serializable id) {
		return productInventoryMapper.deleteById(id);
	}

	@Override
	public int deleteByMap(Map<String, Object> columnMap) {
		return 0;
	}

	@Override
	public int delete(Wrapper<ProductInventoryModel> wrapper) {
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<? extends Serializable> idList) {
		return 0;
	}

	@Override
	public int updateById(ProductInventoryModel entity) {
		return productInventoryMapper.updateById(entity);
	}

	@Override
	public int update(ProductInventoryModel entity, Wrapper<ProductInventoryModel> updateWrapper) {
		return 0;
	}

	@Override
	public ProductInventoryModel selectById(Serializable id) {
		return productInventoryMapper.selectById(id);
	}

	@Override
	public List<ProductInventoryModel> selectBatchIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<ProductInventoryModel> selectByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public ProductInventoryModel selectOne(Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}

	@Override
	public Integer selectCount(Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}

	@Override
	public List<ProductInventoryModel> selectList(Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}

	@Override
	public IPage<ProductInventoryModel> selectPage(IPage<ProductInventoryModel> page, Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}

	@Override
	public IPage<Map<String, Object>> selectMapsPage(IPage<ProductInventoryModel> page, Wrapper<ProductInventoryModel> queryWrapper) {
		return null;
	}
}
