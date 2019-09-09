package com.spring.project.Guest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.Guest.FootballGuest;

@Repository
public class GuestDaoImpl implements GuestDao{

private static final String namespace="com.spring.project.GuestMapper";
	
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<FootballGuest> GuestPost(FootballGuest Guest) throws Exception {
		// TODO Auto-generated method stub
		List<FootballGuest> GuestPost = sqlSession.selectList(namespace+".GuestPost", Guest);
		return GuestPost;
	}
	@Override
	public void upload(FootballGuest Guest) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".upload",Guest);
	}
	@Override
	public FootballGuest GuestContent(FootballGuest Guest)  throws Exception{
		return sqlSession.selectOne(namespace+".GuestContent", Guest);
		
	}
	@Override
	public void updateViewCnt(FootballGuest Guest) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateViewCnt",Guest);
	}

	
	@Override
	public void delete(FootballGuest Guest) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".delete",Guest);
	}
	@Override
	public void update(FootballGuest Guest) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".update",Guest);
	}
	@Override
	public List<FootballGuest> GuestPost2() throws Exception {
List<FootballGuest> GuestPost = sqlSession.selectList(namespace+".GuestPost2");
		
		return GuestPost;
	}
	@Override
	public int MatchinPostCnt(FootballGuest Guest) throws Exception {
		return sqlSession.selectOne(namespace+".GuestPostCnt",Guest);
	}
	
	
	
}
