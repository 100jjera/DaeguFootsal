package com.spring.project.Guest.service;

import java.util.List;

import com.spring.project.Guest.FootballGuest;

public interface GuestService {

	public void upload(FootballGuest Guest) throws Exception;
	public void update(FootballGuest Guest) throws Exception;
	public void delete(FootballGuest Guest) throws Exception;
	public List<FootballGuest>  GuestPost(FootballGuest Guest) throws Exception;
	public List<FootballGuest>  GuestPost2() throws Exception;
	public FootballGuest GuestContent(FootballGuest Guest) throws Exception;
	public int GuestPostCnt(FootballGuest Guest) throws Exception;
}
