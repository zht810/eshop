package com.zht.eshop.inventory.service;

import com.zht.eshop.inventory.model.User;

import java.io.Serializable;
import java.util.List;

/**
 * 用户Service接口
 * @author Administrator
 *
 */
public interface UserService extends BaseServiceCRUD<User>{

	/**
	 * 查询用户信息
	 * @return 用户信息
	 */
	public User findUserInfo();
	
	/**
	 * 查询redis中缓存的用户信息
	 * @return
	 */
    User getCachedUserInfo(Serializable id);

    List<User> listByName(String name);
}
