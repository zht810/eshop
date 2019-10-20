package com.zht.eshop.inventory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.eshop.inventory.model.User;

public interface UserMapper extends BaseMapper<User> {

	User findUserInfo();
	
}
