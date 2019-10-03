package cn.itcast.store.web.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.Map;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;
import cn.itcast.store.service.serviceImp.UserServiceImp;
import cn.itcast.store.utils.MailUtils;
import cn.itcast.store.utils.MyBeanUtils;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	//注册用户界面转发
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	
	//用户注册
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//接收表单参数
		Map<String, String[]> map = request.getParameterMap();
		//遍历map中的元素,[username<---->{"1111"},password<------>{"12462"}]
		System.out.println("注册成功");
		User user = new User();
		//封装前端传过来的属性值
		MyBeanUtils.populate(user, map);
		//补充剩下的前端没有传过来的
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		//调用业务层注册功能
		UserService userService = new UserServiceImp();
		try {
			userService.userRegist(user);
			//发送激活码给用户激活
			MailUtils.sendMail(user.getEmail(), user.getCode());
			//注册成功向用户发送信息，跳转到提示页面	
			request.setAttribute("msg", "用户注册成功,请激活");
			return "/jsp/info.jsp";
		} catch (Exception e) {
			return null;
		}	
		
	}

	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//获取code属性
		String code = request.getParameter("code");
		//向业务层调用服务
		UserService userService = new UserServiceImp();
		//调用业务
		boolean active = userService.userActive(code);
		//当没有激活过，且存在激活码
		if(active && code != null)
		{
			request.setAttribute("msg", "激活成功，请登录");
			return "/jsp/login.jsp";	
		}
		else 
		{
			request.setAttribute("msg", "激活失败，请重新激活");
			return "/jsp/info.jsp";
		}
	}
	
	//用户登录路径转发
	public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/login.jsp";
	}
	//用户登录处理请求
	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//取得前端传过来的用户名(username)和密码(password)
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserServiceImp();
		//判断用户是否存在逻辑处理
		User user = null;
		try
		{
			user = userService.haveUser(username, password);
			request.getSession().setAttribute("userLogin", user);//添加session
			response.sendRedirect("/store_v7/index.jsp");
			return null;
		}		
		catch(Exception e)
		{
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "/jsp/login.jsp"; 
		}
			
	}
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将session置空
		request.getSession().setAttribute("userLogin", null);
		response.sendRedirect("/store_v7/index.jsp");
		return null;
	}

}
