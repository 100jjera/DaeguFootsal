package com.spring.project.User.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.User.FootballUser;
import com.spring.project.User.service.UserService;

@Controller
public class UserController {

	@Inject
	UserService service;
//	@RequestMapping(value="/")
//	public String hom(Model model) throws Exception{
//		return "home";
//	}

	@RequestMapping(value="/signup",method = { RequestMethod.POST,RequestMethod.GET})
	public String signUp(Model model) throws Exception{
		return "User/SignUpForm";
	}
	@RequestMapping(value="/api/signup",method={ RequestMethod.POST,RequestMethod.GET})
	public String apiSigunUp(HttpServletRequest request) throws Exception {
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String name=request.getParameter("name");
		String phoneNum=request.getParameter("phoneNum");
		String birth=request.getParameter("birth");
		
		
		FootballUser user = new FootballUser();
		
		if(id==null||id==""||password==null||password==""||password2==null||password2==""||name==null||name==""||phoneNum==null||phoneNum==""||birth==null||birth=="")
		{
			
			throw new Exception("데이터를 입력하세요");
		
		}
		else if(!password.equals(password2)) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		
		}
		else {
			user.setId(request.getParameter("id"));
			user.setPassword(request.getParameter("password"));
			user.setName(request.getParameter("name"));
			user.setPhoneNum(request.getParameter("phoneNum"));
			user.setBirth(request.getParameter("birth"));
			service.signUp(user);
			return "User/LoginForm";
	
		}
		
	}
	
	@RequestMapping(value="/login",method = { RequestMethod.POST,RequestMethod.GET})
	public String login(FootballUser user) {
		return "/User/LoginForm";
	}
	
	@RequestMapping(value="/api/login",method= {RequestMethod.POST, RequestMethod.GET})
	public String apiLogin(FootballUser user, HttpSession session,HttpServletRequest request,Model model) throws Exception {
		
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		FootballUser LoginUser=service.login(user);
		
		System.out.println(LoginUser);
		
		if(LoginUser==null||!LoginUser.getPassword().equals(user.getPassword())) {
			
			return "redirect:/login";
		}
		else {
			session.setAttribute("loginId", LoginUser.getId());
			
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/logout",method= {RequestMethod.POST, RequestMethod.GET})
	public String logout(FootballUser user,HttpSession session) {
		session.removeAttribute("loginId");
		return "User/LoginForm";
	}

}
