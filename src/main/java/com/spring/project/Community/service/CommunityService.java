package com.spring.project.Community.service;

import java.util.List;

import com.spring.project.Community.FootballCommunity;

public interface CommunityService {

	public void upload(FootballCommunity Community) throws Exception;
	public void update(FootballCommunity Community) throws Exception;
	public void delete(FootballCommunity Community) throws Exception;
	public List<FootballCommunity>  CommunityPost(FootballCommunity Community) throws Exception;
	public List<FootballCommunity>  CommunityPost2() throws Exception;
	public FootballCommunity CommunityContent(FootballCommunity Community) throws Exception;
	public int CommunityPostCnt(FootballCommunity Community) throws Exception;
}
