package com.spring.project.Guest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.project.Pagination;
import com.spring.project.Guest.FootballGuest;
import com.spring.project.Guest.service.GuestService;
import com.spring.project.Guest.service.GuestServiceImpl;

@Controller
public class GuestController {

	@Inject
	GuestService service;
	
	
	
	@RequestMapping(value="/GuestForm" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String GuestForm(  @RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="") String searchOption,
			@RequestParam(defaultValue="") String keyword,
            HttpServletRequest request,Model model) throws Exception{
		
		FootballGuest football =new FootballGuest();
		
		
		List<FootballGuest> GuestPost;
			
		if(!"".equals(searchOption) && !"".equals(keyword)) {
			football.setSearchOption(searchOption);
			football.setKeyword(keyword);
		} else {
			football.setSearchOption("");
			football.setKeyword("");
		}
		
		int listCnt = service.GuestPostCnt(football);
		Pagination pagination=new Pagination(listCnt, curPage);
		football.setStartIndex(pagination.getStartIndex());
		football.setCntPerPage(pagination.getPageSize());
		
		
	
	
		
		
		
		GuestPost = service.GuestPost(football);
		model.addAttribute("pagination",pagination);
		model.addAttribute("listCnt",listCnt);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("keyword",keyword);
		model.addAttribute("GuestPost",GuestPost);
		
		return "Guest/GuestForm";
	}
	
	
	
	
	@RequestMapping(value="/Guest" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String Guest() throws Exception{
		return "Guest/Guest";
	}
	
	@RequestMapping(value="/api/Guest" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String apiGuest(HttpServletRequest request,FootballGuest Guest) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
	
		if(id==null||id==""||title==null||title==""||content=="null"||content=="") {
			throw new Exception("데이터를 입력하세요");
		}
		else {
			Guest.setId(id);
			Guest.setTitle(title);
			Guest.setContent(content);
			service.upload(Guest);
			
			return "redirect:/GuestForm";
		}
		
		
		
	}
	@RequestMapping(value="/api/GuestContent",method = {RequestMethod.POST,RequestMethod.GET})
	public String GuestContent(FootballGuest Guest,Model model,HttpServletRequest request) throws Exception{
		int num=Guest.getNum();
		
		FootballGuest GuestContent =new FootballGuest();
		GuestContent.setNum(num);
		
		FootballGuest guest=service.GuestContent(GuestContent);
		model.addAttribute("GuestContent", guest);
		return "/Guest/GuestContent";
	}
	@RequestMapping(value="/GuestUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String upadateForm(FootballGuest Guest,Model model,HttpServletRequest request) throws Exception{
		
		int num=Guest.getNum();
		FootballGuest GuestContent =new FootballGuest();
		GuestContent.setNum(num);
		
		FootballGuest guest=service.GuestContent(GuestContent);
		model.addAttribute("GuestContent", guest);
		return "/Guest/GuestUpdate";
	}
	@RequestMapping(value = "/api/GuestUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String update(FootballGuest Guest) throws Exception {
		
		service.update(Guest);
		return "redirect:/GuestForm";
	}
	@RequestMapping(value = "/GuestDelete",method = {RequestMethod.POST,RequestMethod.GET})
	public String delete(FootballGuest Guest) throws Exception{
		service.delete(Guest);
		return "redirect:/GuestForm";
	}
}
