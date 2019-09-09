package com.spring.project.Guest.dao;

import java.util.List;

import com.spring.project.Guest.FootballGuest;
import com.spring.project.User.FootballUser;

public interface GuestDao {
	public List<FootballGuest> GuestPost(FootballGuest Guest) throws Exception;
	public List<FootballGuest> GuestPost2() throws Exception;
	public void upload(FootballGuest Guest)  throws Exception;
	public FootballGuest GuestContent(FootballGuest Guest) throws Exception;
	void updateViewCnt(FootballGuest Guest) throws Exception;
	
	
	public void delete(FootballGuest Guest)  throws Exception;
	public void update(FootballGuest Guest)  throws Exception;


	public int MatchinPostCnt(FootballGuest Guest) throws Exception;
}
