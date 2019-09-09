package com.spring.project.Community.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.project.Community.FootballCommunity;
import com.spring.project.Community.dao.CommunityDao;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Inject
	private CommunityDao dao;
	
	@Override
	public void upload(FootballCommunity Community) throws Exception{
		// TODO Auto-generated method stub
		dao.upload(Community);
	}

	@Override
	public List<FootballCommunity> CommunityPost(FootballCommunity Community) throws Exception {
		return dao.CommunityPost(Community);
	}

	@Override
	public FootballCommunity CommunityContent(FootballCommunity Community) throws Exception {
		dao.updateViewCnt(Community);
		return dao.CommunityContent(Community);
	}

	

	@Override
	public void update(FootballCommunity Community) throws Exception {
		dao.update(Community);
		
	}

	@Override
	public void delete(FootballCommunity Community) throws Exception {
		dao.delete(Community);
		
	}

	@Override
	public List<FootballCommunity> CommunityPost2() throws Exception {
		// TODO Auto-generated method stub
		return dao.CommunityPost2();
	}

	@Override
	public int CommunityPostCnt(FootballCommunity Community) throws Exception {
		return dao.MatchinPostCnt(Community);
	}

}
