package com.briup.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.Person;
import com.briup.service.UserLoginService;
import com.mysql.jdbc.StringUtils;

/**
 * @author yyj
 * 
 */
@Controller
public class LoginController {
	@Autowired
	private UserLoginService userLoginService;
	// 日志
	Logger log = LoggerFactory.getLogger(LoginController.class);

	// 登录功能
	@RequestMapping(value = "/Login", method = { RequestMethod.POST })
	public String Login(HttpServletRequest request,
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isEmptyOrWhitespaceOnly(userName)
				&& !StringUtils.isEmptyOrWhitespaceOnly(passWord)) {
			// 用户名密码不为空时
			try {

				Person p = userLoginService.searchPerson(userName);
			
				if (p.getPassword().equals(passWord)) {
					return "adminindex";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			
			log.error("用户名或密码为空,请重新输入");
		}
		return "Error";

	}
}