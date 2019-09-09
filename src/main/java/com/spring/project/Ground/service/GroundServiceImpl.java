package com.spring.project.Ground.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.project.Ground.FootballGround;
import com.spring.project.Ground.dao.GroundDao;

@Service
public class GroundServiceImpl implements GroundService{

	@Inject
	private GroundDao dao;
	
	
	@Override
	public FootballGround GrondCheck(FootballGround Ground) throws Exception {
		// TODO Auto-generated method stub
		return dao.GrondCheck(Ground);
	}

	@Override
	public void GroundRes(FootballGround Ground) throws Exception {
		// TODO Auto-generated method stub
		dao.GroundRes(Ground);
	}

}
