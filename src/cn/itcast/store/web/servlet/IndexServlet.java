package cn.itcast.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.store.web.base.BaseServlet;


public class IndexServlet extends BaseServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/jsp/index.jsp";
	}
}
