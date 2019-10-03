package cn.itcast.store.dao;

import java.sql.SQLException;

import cn.itcast.store.domain.User;


public interface UserDao {

	public void userRegist(User user)throws SQLException;
	public User userActive(String string)throws SQLException;
	public void updateUser(User user)throws SQLException;
	public User selectUser(String username, String password) throws SQLException;

}
