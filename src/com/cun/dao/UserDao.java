package com.cun.dao;

import com.cun.entity.User;

/**
 * User 数据库层接口
 * @author linhongcun
 *
 */
public interface UserDao {
	
	/*
	 * 获取所有的用户
	 */
	User getUserById(Integer id);
}
