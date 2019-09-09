package com.spring.project.Matching.dao;

import java.util.List;

import com.spring.project.Matching.FootballMatching;
import com.spring.project.User.FootballUser;

public interface MatchingDao {
	public List<FootballMatching> MatchingPost(FootballMatching Matching) throws Exception;
	public List<FootballMatching> MatchingPost2() throws Exception;
	public void upload(FootballMatching Matching)  throws Exception;
	public FootballMatching MatchingContent(FootballMatching Matching) throws Exception;
	void updateViewCnt(FootballMatching Matching) throws Exception;
	
	
	public void delete(FootballMatching Matching)  throws Exception;
	public void update(FootballMatching Matching)  throws Exception;


	public int MatchinPostCnt(FootballMatching Matching) throws Exception;
}
