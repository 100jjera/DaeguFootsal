package com.spring.project.Guest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.project.Guest.FootballGuest;
import com.spring.project.Guest.dao.GuestDao;

@Service
public class GuestServiceImpl implements GuestService {

	@Inject
	private GuestDao dao;
	
	@Override
	public void upload(FootballGuest Guest) throws Exception{
		// TODO Auto-generated method stub
		dao.upload(Guest);
	}

	@Override
	public List<FootballGuest> GuestPost(FootballGuest Guest) throws Exception {
		return dao.GuestPost(Guest);
	}

	@Override
	public FootballGuest GuestContent(FootballGuest Guest) throws Exception {
		dao.updateViewCnt(Guest);
		return dao.GuestContent(Guest);
	}

	

	@Override
	public void update(FootballGuest Guest) throws Exception {
		dao.update(Guest);
		
	}

	@Override
	public void delete(FootballGuest Guest) throws Exception {
		dao.delete(Guest);
		
	}

	@Override
	public List<FootballGuest> GuestPost2() throws Exception {
		// TODO Auto-generated method stub
		return dao.GuestPost2();
	}

	@Override
	public int GuestPostCnt(FootballGuest Guest) throws Exception {
		return dao.MatchinPostCnt(Guest);
	}

}
