package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.domain.User;
import cn.itcast.store.utils.JDBCUtils;
/**
 * 用户操作数据层操作
 * @author tangyuan
 *
 * 2019年5月16日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class UserDaoImp implements UserDao {

	@Override
	public void userRegist(User user) throws SQLException {
		
		String sql = "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
						   user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),
						   user.getState(),user.getCode()};
		qr.update(sql, params);
	}

	@Override
	public User userActive(String code) throws SQLException {
		
		String sql = "SELECT * FROM user where code = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		User user = qr.query(sql, new BeanHandler<User>(User.class),code);
		return user;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		//这样一句sql语句就可以解决所有的更新操作。不用每次更新不同的字段就要写一个更新的方法
		String sql =  "UPDATE user SET username=?, password=?, name=?, email=?, telephone=?, birthday=?, sex=?, state=?,code=? where uid=?";
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getUsername(),user.getPassword(),user.getName(),
				   user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),
				  user.getState(),user.getCode(),user.getUid()};
		qr.update(sql, params);
	}

	@Override
	public User selectUser(String username, String password) throws SQLException {

		String sql = "SELECT uid, username, password, name, email, telephone, birthday, sex, state,code FROM user WHERE username=? AND password=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		User user = qr.query(sql, new BeanHandler<User>(User.class),username,password);
		return user;
	}

	




}
