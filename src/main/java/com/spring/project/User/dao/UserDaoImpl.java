package com.spring.project.User.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.User.FootballUser;

@Repository
public class UserDaoImpl implements UserDao {

	private static final String namespace="com.spring.project.UserMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<FootballUser> userSelect() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace+".login");
	}

	@Override
	public void signUp(FootballUser user) {
	
		sqlSession.insert(namespace+".signup", user);
	}

	@Override
	public FootballUser login(FootballUser user) {
		return sqlSession.selectOne(namespace+".login",user);
		// TODO Auto-generated method stub
		
	}



}
