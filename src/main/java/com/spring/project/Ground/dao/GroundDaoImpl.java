package com.spring.project.Ground.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.Ground.FootballGround;

@Repository
public class GroundDaoImpl implements GroundDao{

	private static final String namespace="com.spring.project.GroundMapper";
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public FootballGround GrondCheck(FootballGround Ground) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".GroundCheck",Ground) ;
	}

	@Override
	public void GroundRes(FootballGround Ground) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".GroundRes",Ground);
	}

}
