package com.rpm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpm.domain.Users;
import com.rpm.entity.Formatting;
import com.rpm.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String logins(HttpSession session, HttpServletRequest request, Model model) {
		String username = request.getParameter("username").trim();
		String userpwd = request.getParameter("userpwd").trim();
		if (username.equals("") || userpwd.equals("")) {
			model.addAttribute("loginusername", username);
			request.setAttribute("loginerr", "用户名或密码不能为空");
			return "login";
		}
		Users users = loginService.findusername(username);
		if (users == null) {
			model.addAttribute("loginusername", username);
			request.setAttribute("loginerr", "用户不存在");
			return "login";
		} else if (users.getUsername().equals(username) && users.getUserpwd().equals(userpwd)) {
			session.setAttribute("userlogin", username);
			session.setAttribute("loginusertime", users.getTime_s());
			Users user=new Users();
			Formatting fordate=new Formatting();
			user.setUsername(username);
			user.setTime_s(fordate.ymdhms());
			loginService.updateusertime(user);
			return "redirect:/main";
		}
		model.addAttribute("loginusername", username);
		request.setAttribute("loginerr", "用户名或密码错误");
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/loginfd")
	public String loginforget(Model model) {
		return "loginfd";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/loginfd")
	public String loginfor(HttpSession session, HttpServletRequest request, Model model) {
		String username = request.getParameter("forgetname").trim();
		String idcards = request.getParameter("forgetpwd").trim();
		model.addAttribute("loginfdusername", username);
		model.addAttribute("loginfdusercard", idcards);
		if (username.equals("") || idcards.equals("")) {
			request.setAttribute("loginpwd", "用户名或身份证不能为空");
			return "loginfd";
		}
		Users users = loginService.findusername(username);
		if (users == null) {
			request.setAttribute("loginpwd", "用户不存在");
			return "loginfd";
		} else if (users.getUsername().equals(username) && users.getIdcard().equals(idcards)) {
			request.setAttribute("loginpwd", users.getUserpwd());
			return "loginfd";
		}
		request.setAttribute("loginpwd", "用户名或身份证不匹配");
		return "loginfd";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/loginup")
	public String loginup(HttpSession session,Model model) {
		String username = (String) session.getAttribute("userlogin");
		if (username==null) {
			model.addAttribute("loginerr", "登陆后才能修改密码");
			return "login";
		}
		return "loginup";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/loginup")
	public String loginup(HttpSession session, HttpServletRequest request, Model model) {
		String username = (String) session.getAttribute("userlogin");
		String idcard = request.getParameter("updatacard").trim();
		String pwd = request.getParameter("updatapwd").trim();
		String pwds = request.getParameter("updatapwds").trim();
		model.addAttribute("loginupusercard", idcard);
		if (idcard.equals("") || pwd.equals("") || pwds.equals("")) {
			request.setAttribute("loginpwd", "身份证或密码不能为空");
			return "loginup";
		}
		Users users = loginService.findusername(username);
		if (!users.getIdcard().equals(idcard)) {
			request.setAttribute("loginpwd", "身份不匹配");
			return "loginup";
		} else if (!pwds.equals(pwd)) {
			request.setAttribute("loginpwd", "两次密码不一致");
			return "loginup";
		}
		Users user=new Users();
		user.setIdcard(idcard);
		user.setUserpwd(pwd);
		loginService.updateuserpwd(user);
		return "redirect:/login";
	}
}
