package com.spring.project.Info.controller;

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
import com.spring.project.Info.FootballInfo;
import com.spring.project.Info.service.InfoService;
import com.spring.project.Info.service.InfoServiceImpl;

@Controller
public class InfoController {

	@Inject
	InfoService service;
	
	
	
	@RequestMapping(value="/InfoForm" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String InfoForm(  @RequestParam(defaultValue="1") int curPage, 
			@RequestParam(defaultValue="") String searchOption,
			@RequestParam(defaultValue="") String keyword,
            HttpServletRequest request,Model model) throws Exception{
		
		FootballInfo football =new FootballInfo();
		
		
		List<FootballInfo> InfoPost;
			
		if(!"".equals(searchOption) && !"".equals(keyword)) {
			football.setSearchOption(searchOption);
			football.setKeyword(keyword);
		} else {
			football.setSearchOption("");
			football.setKeyword("");
		}
		
		int listCnt = service.InfoPostCnt(football);
		Pagination pagination=new Pagination(listCnt, curPage);
		football.setStartIndex(pagination.getStartIndex());
		football.setCntPerPage(pagination.getPageSize());
		
		
	
	
		
		
		
		InfoPost = service.InfoPost(football);
		model.addAttribute("pagination",pagination);
		model.addAttribute("listCnt",listCnt);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("keyword",keyword);
		model.addAttribute("InfoPost",InfoPost);
		
		return "Info/InfoForm";
	}
	
	
	
	
	@RequestMapping(value="/Info" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String Info() throws Exception{
		return "Info/Info";
	}
	
	@RequestMapping(value="/api/Info" ,method = {RequestMethod.POST,RequestMethod.GET})
	public String apiInfo(HttpServletRequest request,FootballInfo Info) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
	
		if(id==null||id==""||title==null||title==""||content=="null"||content=="") {
			throw new Exception("insert data");
		}
		else {
			Info.setId(id);
			Info.setTitle(title);
			Info.setContent(content);
			service.upload(Info);
			
			return "redirect:/InfoForm";
		}
		
		
		
	}
	@RequestMapping(value="/api/InfoContent",method = {RequestMethod.POST,RequestMethod.GET})
	public String InfoContent(FootballInfo Info,Model model,HttpServletRequest request) throws Exception{
		int num=Info.getNum();
		
		FootballInfo InfoContent =new FootballInfo();
		InfoContent.setNum(num);
		
		FootballInfo info=service.InfoContent(InfoContent);
		model.addAttribute("InfoContent", info);
		return "/Info/InfoContent";
	}
	@RequestMapping(value="/InfoUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String upadateForm(FootballInfo Info,Model model,HttpServletRequest request) throws Exception{
		
		int num=Info.getNum();
		FootballInfo InfoContent =new FootballInfo();
		InfoContent.setNum(num);
		
		FootballInfo info=service.InfoContent(InfoContent);
		model.addAttribute("InfoContent", info);
		return "/Info/InfoUpdate";
	}
	@RequestMapping(value = "/api/InfoUpdate",method = {RequestMethod.POST,RequestMethod.GET})
	public String update(FootballInfo Info) throws Exception {
		
		service.update(Info);
		return "redirect:/InfoForm";
	}
	@RequestMapping(value = "/InfoDelete",method = {RequestMethod.POST,RequestMethod.GET})
	public String delete(FootballInfo Info) throws Exception{
		service.delete(Info);
		return "redirect:/InfoForm";
	}
}
