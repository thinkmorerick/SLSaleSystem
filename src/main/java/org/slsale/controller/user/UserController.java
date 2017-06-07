package org.slsale.controller.user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slsale.pojo.User;
import org.slsale.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping("/index.html")
	public String index() {
		logger.debug("UserController welcome slsalesystem==========");
		return "index";
	}

	@RequestMapping("/login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("/dologin.html")
	public ModelAndView doLogin(User user) {
		logger.debug("doLogin=====>" + user.getLoginCode() + "---password"
				+ user.getPassword());
		try {
			user = userService.getLoginUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("loginsuccess");
	}

	@RequestMapping("/exit.html")
	public String exit() {
		return "exit";
	}

	@RequestMapping("/register.html")
	public String register() {
		return "register";
	}

	@RequestMapping("/doregister.html")
	public ModelAndView doRegister(User user) {
		int f;
		try {
			f = userService.addUser(user);
			if (f > 0) {
				user = userService.getLoginUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("regsuccess");
	}

}
