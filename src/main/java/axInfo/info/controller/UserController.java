package axInfo.info.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiufengxinxi.core.entity.JsonResult;

import axInfo.info.base.utils.AppUtil;
import axInfo.info.base.utils.MD5Utils;
import axInfo.info.entity.User;
import axInfo.info.mapper.UserMapper;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserMapper UserMapper;

	/**
	 * 登录页面
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("/login")
	public String getLogin(Model m) {
		logger.info("操作进入登录页面");
		return "/login/login";
	}

	@RequestMapping(value = "/index")
	public String getInfo(Model m) {

		return "/index";
	}

	@RequestMapping(value = "/test")
	public String getTest(Model m) {

		return "/info/indexInfo/learning";
	}

	@RequestMapping(value = "/register")
	public String getRegister(Model m) {
		logger.info("操作进入注册页面");

		return "/register/register";
	}

	@RequestMapping(value = "/user/userSave")
	public Object getUserSave(User user, HttpServletRequest request,Model model) {
		user.setUserPassWord(MD5Utils.getMd5(user.getUserPassWord()));
		int saveState = 0;
		try {
			saveState = UserMapper.save(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (saveState == 0) {
			model.addAttribute("registerError",true);
			model.addAttribute("user",user);
			return "/register/register";
		} else {
			request.getSession().setAttribute("user", user);
		}
		return "/index";
	}
	
	@RequestMapping(value = "/user/Login")
	public Object getUserLogin(User user, HttpServletRequest request,Model model) {
		String ss = null;
		System.out.println(ss);
	   String userPassWord = MD5Utils.getMd5(user.getUserPassWord());
	   User loginuser = null;
	   HashMap< String, String> map = new HashMap<String, String>();
	   map.put("userEmail",user.getUserEmail());
	   map.put("userPassWord",userPassWord);
	   try {
		   loginuser = UserMapper.getLogin(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (loginuser == null) {
			model.addAttribute("loginError",true);
			model.addAttribute("user",user);
			return "/login/login";  
		} else {
			request.getSession().setAttribute("user", user);
		}
		return "/index";
	}
}
