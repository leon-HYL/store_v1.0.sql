package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;



import cn.itcast.store.dao.UserDao;
import cn.itcast.store.dao.daoImp.UserDaoImp;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;
/**
 * 用户功能实现层
 * @author tangyuan
 *
 * 2019年5月16日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class UserServiceImp implements UserService {

	
	/**
	 * 实现用户注册功能
	 * @throws SQLException 
	 */
	@Override
	public void userRegist(User user) throws SQLException {
		UserDao userDao = new UserDaoImp();
		userDao.userRegist(user);
	}

	@Override
	public boolean userActive(String code) throws SQLException {
		UserDao userDao = new UserDaoImp();
		User user = userDao.userActive(code);
		if(user != null)
		{
			//更新用户的状态和code
			user.setState(1);
			user.setCode("");
			userDao.updateUser(user);
			return true;
		}else {
			return false;
		}
		
		
		
	}

	@Override
	public User haveUser(String username, String password) throws SQLException {
		
		UserDao userDao = new UserDaoImp();
		//查询语句
		User user = userDao.selectUser(username, password);
		//账号或密码错误
		if(user == null)
		{
			throw new RuntimeException("用户名或密码有误");
		}if(user.getState() == 0)//用户未激活
		{
			throw new RuntimeException("用户未激活");
		}
		else {
			return user;	
		}
		
	}



}
