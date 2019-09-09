package com.spring.project.User.dao;
import java.util.List;

import com.spring.project.User.FootballUser;
public interface UserDao {
	public List<FootballUser> userSelect() throws Exception;
	public void signUp(FootballUser user);
	public FootballUser login(FootballUser user);
}
