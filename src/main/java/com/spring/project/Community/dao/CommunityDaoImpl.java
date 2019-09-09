package com.spring.project.Community.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.Community.FootballCommunity;

@Repository
public class CommunityDaoImpl implements CommunityDao{

private static final String namespace="com.spring.project.CommunityMapper";
	
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<FootballCommunity> CommunityPost(FootballCommunity Community) throws Exception {
		// TODO Auto-generated method stub
		List<FootballCommunity> CommunityPost = sqlSession.selectList(namespace+".CommunityPost", Community);
		return CommunityPost;
	}
	@Override
	public void upload(FootballCommunity Community) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".upload",Community);
	}
	@Override
	public FootballCommunity CommunityContent(FootballCommunity Community)  throws Exception{
		return sqlSession.selectOne(namespace+".CommunityContent", Community);
		
	}
	@Override
	public void updateViewCnt(FootballCommunity Community) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateViewCnt",Community);
	}

	
	@Override
	public void delete(FootballCommunity Community) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".delete",Community);
	}
	@Override
	public void update(FootballCommunity Community) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".update",Community);
	}
	@Override
	public List<FootballCommunity> CommunityPost2() throws Exception {
List<FootballCommunity> CommunityPost = sqlSession.selectList(namespace+".CommunityPost2");
		
		return CommunityPost;
	}
	@Override
	public int MatchinPostCnt(FootballCommunity Community) throws Exception {
		return sqlSession.selectOne(namespace+".CommunityPostCnt",Community);
	}
	
	
	
}
