package cn.slsale.test;

import org.apache.log4j.Logger;
import org.slsale.pojo.User;

public class Test_log4j {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(User.class);
		logger.debug("开始");
		logger.debug("结束");
	}
}
