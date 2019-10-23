package com.spring.project.Community.controller;

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
import com.spring.project.Community.FootballCommunity;
import com.spring.project.Community.service.CommunityService;
import com.spring.project.Community.service.CommunityServiceImpl;

@Controller
public class CommunityController {

	@Inject
	CommunityService service;
	
	
	
	@RequestMapping(value="/CommunityForm" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String CommunityForm(  @RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="") String searchOption,
			@RequestParam(defaultValue="") String keyword,
            HttpServletRequest request,Model model) throws Exception{
		
		FootballCommunity football =new FootballCommunity();
		
		
		List<FootballCommunity> CommunityPost;
			
		if(!"".equals(searchOption) && !"".equals(keyword)) {
			football.setSearchOption(searchOption);
			football.setKeyword(keyword);
		} else {
			football.setSearchOption("");
			football.setKeyword("");
		}
		
		int listCnt = service.CommunityPostCnt(football);
		Pagination pagination=new Pagination(listCnt, curPage);
		football.setStartIndex(pagination.getStartIndex());
		football.setCntPerPage(pagination.getPageSize());
		
		
	
	
		
		
		
		CommunityPost = service.CommunityPost(football);
		model.addAttribute("pagination",pagination);
		model.addAttribute("listCnt",listCnt);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("keyword",keyword);
		model.addAttribute("CommunityPost",CommunityPost);
		
		return "Community/CommunityForm";
	}
	
	
	
	
	@RequestMapping(value="/Community" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String Community() throws Exception{
		return "Community/Community";
	}
	
	@RequestMapping(value="/api/Community" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String apiCommunity(HttpServletRequest request,FootballCommunity Community) throws Exception{
//		
//		request.setCharacterEncoding("UTF-8");
//		String id=request.getParameter("id");
//		String title=request.getParameter("title");
//		String content=request.getParameter("content");
//		
//		
//	
//		if(id==null||id==""||title==null||title==""||content=="null"||content=="") {
//			throw new Exception("");
//		}
//		else {
//			Community.setId(id);
//			Community.setTitle(title);
//			Community.setContent(content);
//		}
		
		service.upload(Community);
		
		return "redirect:/CommunityForm";
		
		
	}
	@RequestMapping(value="/api/CommunityContent",method = {RequestMethod.POST,RequestMethod.GET})
	public String CommunityContent(FootballCommunity Community,Model model,HttpServletRequest request) throws Exception{
		int num=Community.getNum();
		
		FootballCommunity CommunityContent =new FootballCommunity();
		CommunityContent.setNum(num);
		
		FootballCommunity community=service.CommunityContent(CommunityContent);
		model.addAttribute("CommunityContent", community);
		return "/Community/CommunityContent";
	}
	@RequestMapping(value="/CommunityUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String upadateForm(FootballCommunity Community,Model model,HttpServletRequest request) throws Exception{
		
		int num=Community.getNum();
		FootballCommunity CommunityContent =new FootballCommunity();
		CommunityContent.setNum(num);
		
		FootballCommunity community=service.CommunityContent(CommunityContent);
		model.addAttribute("CommunityContent", community);
		return "/Community/CommunityUpdate";
	}
	@RequestMapping(value = "/api/CommunityUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String update(FootballCommunity Community) throws Exception {
		
		service.update(Community);
		return "redirect:/CommunityForm";
	}
	@RequestMapping(value = "/CommunityDelete",method = {RequestMethod.POST,RequestMethod.GET})
	public String delete(FootballCommunity Community) throws Exception{
		service.delete(Community);
		return "redirect:/CommunityForm";
	}
}
