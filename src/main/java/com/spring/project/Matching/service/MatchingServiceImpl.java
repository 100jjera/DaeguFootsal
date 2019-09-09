package com.spring.project.Matching.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.project.Matching.FootballMatching;
import com.spring.project.Matching.dao.MatchingDao;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Inject
	private MatchingDao dao;
	
	@Override
	public void upload(FootballMatching Matching) throws Exception{
		// TODO Auto-generated method stub
		dao.upload(Matching);
	}

	@Override
	public List<FootballMatching> MatchingPost(FootballMatching Matching) throws Exception {
		return dao.MatchingPost(Matching);
	}

	@Override
	public FootballMatching MatchingContent(FootballMatching Matching) throws Exception {
		dao.updateViewCnt(Matching);
		return dao.MatchingContent(Matching);
	}

	

	@Override
	public void update(FootballMatching Matching) throws Exception {
		dao.update(Matching);
		
	}

	@Override
	public void delete(FootballMatching Matching) throws Exception {
		dao.delete(Matching);
		
	}

	@Override
	public List<FootballMatching> MatchingPost2() throws Exception {
		// TODO Auto-generated method stub
		return dao.MatchingPost2();
	}

	@Override
	public int MatchingPostCnt(FootballMatching Matching) throws Exception {
		return dao.MatchinPostCnt(Matching);
	}

}
