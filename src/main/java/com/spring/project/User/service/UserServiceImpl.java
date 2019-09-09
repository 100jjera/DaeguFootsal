package com.spring.project.User.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.project.User.FootballUser;
import com.spring.project.User.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao dao;

	@Override
	public List<FootballUser> userSelect() throws Exception {
		// TODO Auto-generated method stub
		return dao.userSelect();
	}
	@Override
	public void signUp(FootballUser user) throws Exception {
		// TODO Auto-generated method stub
		dao.signUp(user);
	}
	@Override
	public FootballUser login(FootballUser user) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(user);
	}



}
