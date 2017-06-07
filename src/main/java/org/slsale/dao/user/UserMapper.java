package org.slsale.dao.user;

import org.slsale.pojo.User;

public interface UserMapper {
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user) throws Exception;

	/**
	 * 	增加用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user) throws Exception;
}
