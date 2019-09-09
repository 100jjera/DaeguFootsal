package com.spring.project.Info.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.project.Info.FootballInfo;
import com.spring.project.Info.dao.InfoDao;

@Service
public class InfoServiceImpl implements InfoService {

	@Inject
	private InfoDao dao;
	
	@Override
	public void upload(FootballInfo Info) throws Exception{
		// TODO Auto-generated method stub
		dao.upload(Info);
	}

	@Override
	public List<FootballInfo> InfoPost(FootballInfo Info) throws Exception {
		return dao.InfoPost(Info);
	}

	@Override
	public FootballInfo InfoContent(FootballInfo Info) throws Exception {
		dao.updateViewCnt(Info);
		return dao.InfoContent(Info);
	}

	

	@Override
	public void update(FootballInfo Info) throws Exception {
		dao.update(Info);
		
	}

	@Override
	public void delete(FootballInfo Info) throws Exception {
		dao.delete(Info);
		
	}

	@Override
	public List<FootballInfo> InfoPost2() throws Exception {
		// TODO Auto-generated method stub
		return dao.InfoPost2();
	}

	@Override
	public int InfoPostCnt(FootballInfo Info) throws Exception {
		return dao.MatchinPostCnt(Info);
	}

}
