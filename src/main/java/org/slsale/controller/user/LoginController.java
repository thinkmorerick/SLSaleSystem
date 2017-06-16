package org.slsale.controller.user;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.pojo.User;
import org.slsale.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@Resource
	private UserService userService;

	@RequestMapping("/main.html")
	public ModelAndView main(HttpSession session) {
		User currentUser = (User) session.getAttribute(Constants.SESSION_USER);
		logger.error("main=================" + currentUser.getLoginCode());
		return new ModelAndView("main");
	}

	@RequestMapping("/login.html")
	@ResponseBody
	public Object login(HttpSession session, @RequestParam String user) {
		if (null == user || "".equals(user)) {
			return "nodata";
		} else {
			JSONObject userObject = JSONObject.fromObject(user);
			User userObj = (User) JSONObject.toBean(userObject, User.class);
			try {
				if (userService.loginCodeIsExit(userObj) == 0) { // 不存在这个登录账号
					return "nologincode";
				} else {
					User _user = userService.getLoginUser(userObj);
					if (null != _user) { // 登录成功
						// 当前用户存到session中
						session.setAttribute(Constants.SESSION_USER, _user);
						// 更新当前用户登录的lastLoginTime
						User updateLoginTimeUser = new User();
						updateLoginTimeUser.setId(_user.getId());
						updateLoginTimeUser.setLastLoginTime(new Date());
						userService.modifyUser(updateLoginTimeUser);
						updateLoginTimeUser = null;
						return "success";
					} else { // 密码错误
						return "pwderror";
					}
				}
			} catch (Exception e) {
				return "failed";
			}
		}
	}
}
