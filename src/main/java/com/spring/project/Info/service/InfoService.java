package com.spring.project.Info.service;

import java.util.List;

import com.spring.project.Info.FootballInfo;

public interface InfoService {

	public void upload(FootballInfo Info) throws Exception;
	public void update(FootballInfo Info) throws Exception;
	public void delete(FootballInfo Info) throws Exception;
	public List<FootballInfo>  InfoPost(FootballInfo Info) throws Exception;
	public List<FootballInfo>  InfoPost2() throws Exception;
	public FootballInfo InfoContent(FootballInfo Info) throws Exception;
	public int InfoPostCnt(FootballInfo Info) throws Exception;
}
