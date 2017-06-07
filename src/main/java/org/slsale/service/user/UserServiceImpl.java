package org.slsale.service.user;

import javax.annotation.Resource;

import org.slsale.dao.user.UserMapper;
import org.slsale.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getLoginUser(User user) throws Exception {
		return userMapper.getLoginUser(user);
	}

	@Override
	public int addUser(User user) throws Exception {
		return userMapper.addUser(user);
	}

}
