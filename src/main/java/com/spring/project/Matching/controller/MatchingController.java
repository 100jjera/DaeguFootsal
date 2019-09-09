package com.spring.project.Matching.controller;

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
import com.spring.project.Matching.FootballMatching;
import com.spring.project.Matching.service.MatchingService;
import com.spring.project.Matching.service.MatchingServiceImpl;

@Controller
public class MatchingController {

	@Inject
	MatchingService service;
	
	
	
	@RequestMapping(value="/MatchingForm" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String MatchingForm(  @RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="") String searchOption,
			@RequestParam(defaultValue="") String keyword,
            HttpServletRequest request,Model model) throws Exception{
		
		FootballMatching football =new FootballMatching();
		
		
		List<FootballMatching> MatchingPost;
			
		if(!"".equals(searchOption) && !"".equals(keyword)) {
			football.setSearchOption(searchOption);
			football.setKeyword(keyword);
		} else {
			football.setSearchOption("");
			football.setKeyword("");
		}
		
		int listCnt = service.MatchingPostCnt(football);
		Pagination pagination=new Pagination(listCnt, curPage);
		football.setStartIndex(pagination.getStartIndex());
		football.setCntPerPage(pagination.getPageSize());
		
		
	
	
		
		
		
		MatchingPost = service.MatchingPost(football);
		model.addAttribute("pagination",pagination);
		model.addAttribute("listCnt",listCnt);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("keyword",keyword);
		model.addAttribute("MatchingPost",MatchingPost);
		
		return "Matching/MatchingForm";
	}
	
	
	
	
	@RequestMapping(value="/Matching" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String Matching() throws Exception{
		return "Matching/Matching";
	}
	
	@RequestMapping(value="/api/Matching" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String apiMatching(HttpServletRequest request,FootballMatching Matching) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
	
		if(id==null||id==""||title==null||title==""||content=="null"||content=="") {
			throw new Exception("데이터를 입력하세요");
		}
		else {
			Matching.setId(id);
			Matching.setTitle(title);
			Matching.setContent(content);
			service.upload(Matching);
			
			return "redirect:/MatchingForm";
		}
		
		
		
	}
	@RequestMapping(value="/api/MatchingContent",method = {RequestMethod.POST,RequestMethod.GET})
	public String MatchingContent(FootballMatching Matching,Model model,HttpServletRequest request) throws Exception{
		int num=Matching.getNum();
		
		FootballMatching MatchingContent =new FootballMatching();
		MatchingContent.setNum(num);
		
		FootballMatching matching=service.MatchingContent(MatchingContent);
		model.addAttribute("MatchingContent", matching);
		return "/Matching/MatchingContent";
	}
	@RequestMapping(value="/MatchingUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String upadateForm(FootballMatching Matching,Model model,HttpServletRequest request) throws Exception{
		
		int num=Matching.getNum();
		FootballMatching MatchingContent =new FootballMatching();
		MatchingContent.setNum(num);
		
		FootballMatching matching=service.MatchingContent(MatchingContent);
		model.addAttribute("MatchingContent", matching);
		return "/Matching/MatchingUpdate";
	}
	@RequestMapping(value = "/api/MatchingUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String update(FootballMatching Matching) throws Exception {
		
		service.update(Matching);
		return "redirect:/MatchingForm";
	}
	@RequestMapping(value = "/MatchingDelete",method = {RequestMethod.POST,RequestMethod.GET})
	public String delete(FootballMatching Matching) throws Exception{
		service.delete(Matching);
		return "redirect:/MatchingForm";
	}
}
