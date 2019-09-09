package com.spring.project.Ground.dao;

import com.spring.project.Ground.FootballGround;

public interface GroundDao {
	public FootballGround GrondCheck(FootballGround Ground) throws Exception;
	public void GroundRes(FootballGround Ground) throws Exception;
}
