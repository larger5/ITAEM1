package com.cun.service.impl;

import com.cun.dao.UserDao;
import com.cun.dao.impl.UserDaoImpl;
import com.cun.entity.User;
import com.cun.service.UserService;

/**
 * User 事务层实现类
 * @author linhongcun
 *
 */
public class UserServiceImpl implements UserService {

	UserDao userDao=new UserDaoImpl();
	
	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

}
