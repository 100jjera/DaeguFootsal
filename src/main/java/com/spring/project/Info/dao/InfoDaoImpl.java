package com.spring.project.Info.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.project.Info.FootballInfo;

@Repository
public class InfoDaoImpl implements InfoDao{

private static final String namespace="com.spring.project.InfoMapper";
	
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<FootballInfo> InfoPost(FootballInfo Info) throws Exception {
		// TODO Auto-generated method stub
		List<FootballInfo> InfoPost = sqlSession.selectList(namespace+".InfoPost", Info);
		return InfoPost;
	}
	@Override
	public void upload(FootballInfo Info) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".upload",Info);
	}
	@Override
	public FootballInfo InfoContent(FootballInfo Info)  throws Exception{
		return sqlSession.selectOne(namespace+".InfoContent", Info);
		
	}
	@Override
	public void updateViewCnt(FootballInfo Info) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateViewCnt",Info);
	}

	
	@Override
	public void delete(FootballInfo Info) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".delete",Info);
	}
	@Override
	public void update(FootballInfo Info) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".update",Info);
	}
	@Override
	public List<FootballInfo> InfoPost2() throws Exception {
List<FootballInfo> InfoPost = sqlSession.selectList(namespace+".InfoPost2");
		
		return InfoPost;
	}
	@Override
	public int MatchinPostCnt(FootballInfo Info) throws Exception {
		return sqlSession.selectOne(namespace+".InfoPostCnt",Info);
	}
	
	
	
}
