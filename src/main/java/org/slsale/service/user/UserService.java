package org.slsale.service.user;

import org.slsale.pojo.User;

public interface UserService {
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user) throws Exception;

	/**
	 * 注册用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user) throws Exception;
}
