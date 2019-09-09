package com.spring.project.Matching.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.Matching.FootballMatching;

@Repository
public class MatchingDaoImpl implements MatchingDao{

private static final String namespace="com.spring.project.MatchingMapper";
	
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<FootballMatching> MatchingPost(FootballMatching Matching) throws Exception {
		// TODO Auto-generated method stub
		List<FootballMatching> MatchingPost = sqlSession.selectList(namespace+".MatchingPost", Matching);
		return MatchingPost;
	}
	@Override
	public void upload(FootballMatching Matching) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".upload",Matching);
	}
	@Override
	public FootballMatching MatchingContent(FootballMatching Matching)  throws Exception{
		return sqlSession.selectOne(namespace+".MatchingContent", Matching);
		
	}
	@Override
	public void updateViewCnt(FootballMatching Matching) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateViewCnt",Matching);
	}

	
	@Override
	public void delete(FootballMatching Matching) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".delete",Matching);
	}
	@Override
	public void update(FootballMatching Matching) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".update",Matching);
	}
	@Override
	public List<FootballMatching> MatchingPost2() throws Exception {
List<FootballMatching> MatchingPost = sqlSession.selectList(namespace+".MatchingPost2");
		
		return MatchingPost;
	}
	@Override
	public int MatchinPostCnt(FootballMatching Matching) throws Exception {
		return sqlSession.selectOne(namespace+".MatchingPostCnt",Matching);
	}
	
	
	
}
