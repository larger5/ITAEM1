package com.cun.service;

import com.cun.entity.User;

/**
 * 事务层接口
 * @author linhongcun
 *
 */
public interface UserService {
	
	User getUserById(Integer id);

}
