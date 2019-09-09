package com.spring.project.Ground.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.Ground.FootballGround;
import com.spring.project.Ground.service.GroundService;

@Controller
public class GroundController {
	
	@Inject
	GroundService service;
	
	@RequestMapping(value="/GroundForm" ,method= {RequestMethod.GET,RequestMethod.POST})
	public String GroundForm(FootballGround Ground,Model model) throws Exception {
		
		return "Ground/GroundForm";
	}
	
	@RequestMapping(value="/GroundCheck",method= {RequestMethod.GET,RequestMethod.POST})
	public String GroundCheck(FootballGround Ground,Model model,HttpServletRequest request) throws Exception{
		
	
	    
	    String resDate=Ground.getResDate();
	    FootballGround GroundCheck =new FootballGround();
		
	
	
			GroundCheck.setResDate(resDate);
				
		FootballGround groundcheck=service.GrondCheck(GroundCheck);
		model.addAttribute("GroundCheck",groundcheck);
		return "Ground/GroundForm";
	}
	
	@RequestMapping(value="/api/Ground",method= {RequestMethod.GET,RequestMethod.POST})
	public String GroundRes(FootballGround Ground,Model model,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String ResId=request.getParameter("ResId");
		String ResDate=request.getParameter("ResDate");
		String Time1=request.getParameter("Time1");
		String Time2=request.getParameter("Time2");
		String Time3=request.getParameter("Time3");
		String Time4=request.getParameter("Time4");
		String Time5=request.getParameter("Time5");
			
		Ground.setResDate(ResDate);
		Ground.setResId(ResId);
		if(Time1==null && Time2==null &&Time3==null &&Time4==null &&Time5==null) {
			return "redirect:/GroundForm";
		}
		
		if(Time1!=null) {
			Ground.setTime1(ResId);
		}
		if(Time2!=null) {
			Ground.setTime2(ResId);
		}
		if(Time3!=null) {
			Ground.setTime3(ResId);
		}
		if(Time4!=null) {
			Ground.setTime4(ResId);
		}
		if(Time5!=null) {
			Ground.setTime5(ResId);
		}
		
		service.GroundRes(Ground);
	
			
		return "redirect:/GroundForm";
	}
}
