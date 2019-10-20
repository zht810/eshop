package com.zht.eshop.inventory.controller;

import com.zht.eshop.inventory.model.User;
import com.zht.eshop.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户Controller控制器
 * @author Administrator
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserInfo")
	public User getUserInfo() {
		User user = userService.findUserInfo();
		return user;
	}
	
	@RequestMapping("/getCachedUserInfo")
	public User getCachedUserInfo() {
		User user = userService.getCachedUserInfo(1);
		return user;
	}

	@RequestMapping("/insert")
	public int insert() {
		User model = new User();
		model.setName("zhangsan");
		model.setAge(30);
		return userService.insert(model);
	}

	@RequestMapping("/delete")
	public int delete(Long id) {
		return userService.deleteById(id);
	}

	@RequestMapping("/update")
	public int update() {
		User model = new User();
		model.setId(1L);
		model.setName("taiyonghai");
		model.setAge(30);
		return userService.updateById(model);
	}

	@RequestMapping("/get")
	public User get(Long id) {
		return userService.selectById(id);
	}

	@RequestMapping("/list")
	public List<User> list() {
		List<User> list = userService.listByName("zhangsan");
		return list;
	}


	
}
