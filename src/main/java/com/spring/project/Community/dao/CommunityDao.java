package com.spring.project.Community.dao;

import java.util.List;

import com.spring.project.Community.FootballCommunity;
import com.spring.project.User.FootballUser;

public interface CommunityDao {
	public List<FootballCommunity> CommunityPost(FootballCommunity Community) throws Exception;
	public List<FootballCommunity> CommunityPost2() throws Exception;
	public void upload(FootballCommunity Community)  throws Exception;
	public FootballCommunity CommunityContent(FootballCommunity Community) throws Exception;
	void updateViewCnt(FootballCommunity Community) throws Exception;
	
	
	public void delete(FootballCommunity Community)  throws Exception;
	public void update(FootballCommunity Community)  throws Exception;


	public int MatchinPostCnt(FootballCommunity Community) throws Exception;
}
