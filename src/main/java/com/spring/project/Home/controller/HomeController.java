package com.spring.project.Home.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.Community.FootballCommunity;
import com.spring.project.Community.service.CommunityService;
import com.spring.project.Guest.FootballGuest;
import com.spring.project.Guest.service.GuestService;
import com.spring.project.Info.service.InfoService;
import com.spring.project.Matching.FootballMatching;
import com.spring.project.Matching.service.MatchingService;

@Controller
public class HomeController {
	@Inject
	MatchingService service;
	@Inject
	CommunityService service2;
	@Inject
	GuestService service3;
	
	
	@RequestMapping(value="/home",method= {RequestMethod.GET,RequestMethod.POST})
	public String HomeForm(Model model) throws Exception{
		List<FootballMatching> MatchingPost2;
		MatchingPost2 = service.MatchingPost2();
		
		List<FootballCommunity> CommunityPost2;
		CommunityPost2 = service2.CommunityPost2();
		
		List<FootballGuest> GuestPost2;
		GuestPost2 = service3.GuestPost2();
		
		
		model.addAttribute("MatchingPost2",MatchingPost2);
		model.addAttribute("CommunityPost2",CommunityPost2);
		model.addAttribute("GuestPost2", GuestPost2);
		
		return "/home";
	}

}
