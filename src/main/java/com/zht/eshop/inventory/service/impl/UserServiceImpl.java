package com.zht.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zht.eshop.inventory.mapper.UserMapper;
import com.zht.eshop.inventory.model.User;
import com.zht.eshop.inventory.service.UserService;
import com.zht.eshop.redis.config.RedisConverter;
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
@Service("userService")  
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;


    @Override
	public User findUserInfo() {
		return userMapper.findUserInfo();
	}

	@Override
	public User getCachedUserInfo(Serializable id) {
        String key = RedisKeyManage.userKey + id.toString();
        RedisConverter redisConverter = new  RedisConverter();
        Object objUser = redisUtil.get(key);
        if (objUser == null) {
            System.out.println("redis缓存不存在");
            User user = selectById(id);
            redisUtil.set(key, user, 2000L);
            return user;
        } else {
            System.out.println("redis缓存中取");
            return (User) objUser;
        }
	}

	public int insert(User model) {
		return userMapper.insert(model);
	}

	@Override
	public int deleteById(Serializable id) {
		return userMapper.deleteById(id);
	}

	@Override
	public int deleteByMap(Map<String, Object> columnMap) {
		return 0;
	}

	@Override
	public int delete(Wrapper<User> wrapper) {
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<? extends Serializable> idList) {
		return 0;
	}

	@Override
	public int updateById(User entity) {
		return userMapper.updateById(entity);
	}

	@Override
	public int update(User entity, Wrapper<User> updateWrapper) {
		return 0;
	}

	@Override
	public User selectById(Serializable id) {
		return userMapper.selectById(id);
	}

	@Override
	public List<User> selectBatchIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<User> selectByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public User selectOne(Wrapper<User> queryWrapper) {
		return null;
	}

	@Override
	public Integer selectCount(Wrapper<User> queryWrapper) {
		return null;
	}

	@Override
	public List<User> selectList(Wrapper<User> queryWrapper) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper) {
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<User> queryWrapper) {
		return null;
	}

	@Override
	public IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper) {
		return null;
	}

	@Override
	public IPage<Map<String, Object>> selectMapsPage(IPage<User> page, Wrapper<User> queryWrapper) {
		return null;
	}



//	public int update(User model) {
//		//更新全部字段，但可以跟application.yml中的field-strategy字段策略相配合，不更新为null或为空的字段
//		return userMapper.updateById(model);
//		//更新全部字段，且不可为NULL
//		//return mapper.updateAllColumnById(model);
//	}

	@Override
	public List<User> listByName(String name) {
		LambdaQueryWrapper<User> userEW = new QueryWrapper<User>()
				.lambda().eq(User::getName, name);
		return userMapper.selectList(userEW);
	}

}
