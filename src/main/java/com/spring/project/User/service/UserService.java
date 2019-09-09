package com.spring.project.User.service;

import java.util.List;

import com.spring.project.User.FootballUser;

public interface UserService {
	public List<FootballUser> userSelect() throws Exception;
	public void signUp(FootballUser user) throws Exception;
	public FootballUser login(FootballUser user) throws Exception;
}
