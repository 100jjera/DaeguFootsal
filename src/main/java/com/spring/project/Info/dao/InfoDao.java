package com.spring.project.Info.dao;

import java.util.List;

import com.spring.project.Info.FootballInfo;
import com.spring.project.User.FootballUser;

public interface InfoDao {
	public List<FootballInfo> InfoPost(FootballInfo Info) throws Exception;
	public List<FootballInfo> InfoPost2() throws Exception;
	public void upload(FootballInfo Info)  throws Exception;
	public FootballInfo InfoContent(FootballInfo Info) throws Exception;
	void updateViewCnt(FootballInfo Info) throws Exception;
	
	
	public void delete(FootballInfo Info)  throws Exception;
	public void update(FootballInfo Info)  throws Exception;


	public int MatchinPostCnt(FootballInfo Info) throws Exception;
}
