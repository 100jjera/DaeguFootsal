package com.spring.project.Matching.service;

import java.util.List;

import com.spring.project.Matching.FootballMatching;

public interface MatchingService {

	public void upload(FootballMatching Matching) throws Exception;
	public void update(FootballMatching Matching) throws Exception;
	public void delete(FootballMatching Matching) throws Exception;
	public List<FootballMatching>  MatchingPost(FootballMatching Matching) throws Exception;
	public List<FootballMatching>  MatchingPost2() throws Exception;
	public FootballMatching MatchingContent(FootballMatching Matching) throws Exception;
	public int MatchingPostCnt(FootballMatching Matching) throws Exception;
}
