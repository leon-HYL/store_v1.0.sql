package cn.itcast.store.service;

import java.sql.SQLException;

import cn.itcast.store.domain.User;


public interface UserService {

	public void userRegist(User user)throws SQLException;
	public boolean userActive(String string) throws SQLException;
	public User haveUser(String username, String password)throws SQLException;
}
