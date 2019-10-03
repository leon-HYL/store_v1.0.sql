package cn.itcast.store.web.servlet;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.service.serviceImp.CategoryServiceImp;
import cn.itcast.store.utils.JedisUtils;
import cn.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;
public class CategoryServlet extends BaseServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findAllcategorys(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		CategoryServiceImp category = new CategoryServiceImp();
		//取得所有条目
		List<Category> list = category.getAllCategory();
		Jedis jedis = JedisUtils.getJedis();//调用redis
		String jsonStr = jedis.get("allList");
		if(null == jsonStr || "".equals(jsonStr))//redis缓冲中没有数据
		{			
			jsonStr=JSONArray.fromObject(list).toString();//转为json格式数据
			jedis.set("allList", jsonStr);//添加到redis缓存中
		} else {//redis缓存中存在
		
			jsonStr = jedis.get("allList");
		}
		JedisUtils.closeJedis(jedis);
		//添加属性
		
		response.setContentType("application/json;charset=utf-8");//告诉浏览器本次相应的是json格式的数据
		response.getWriter().print(jsonStr);
		
		return null;
	}
}
