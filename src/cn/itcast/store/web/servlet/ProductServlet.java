package cn.itcast.store.web.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImp.ProductServiceImp;
import cn.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;

public class ProductServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String findHotProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ProductService product = new ProductServiceImp();
		//取得所有条目
		List<Product> allList = product.gethotProduct();
		//转为json
		String productList = JSONArray.fromObject(allList).toString();
		response.setContentType("application/json;charset=utf-8");//告诉浏览器本次相应的是json格式的数据
		response.getWriter().print(productList);
		return null;
	}
public String findNewProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	
	ProductService product = new ProductServiceImp();
	//取得所有条目
	List<Product> allList = product.getNewProduct();
	//转为json
	String productList = JSONArray.fromObject(allList).toString();
	response.setContentType("application/json;charset=utf-8");//告诉浏览器本次相应的是json格式的数据
	response.getWriter().print(productList);
	return null;
	}
//查找商品信息
public String finProductInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException{
	
	String pid = request.getParameter("pid");
	ProductService productService = new ProductServiceImp();
	Product productInfo = productService.finProductInfoByPid(pid);
	request.setAttribute("productInfo", productInfo);
	return "/jsp/product_info.jsp";
	}
//findProductsByCidWithPage
public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws SQLException{
	
	//分类
	String cid = request.getParameter("cid");
	//当前页
	int curPage = Integer.parseInt(request.getParameter("num"));
	
	//调用业务层功能
	ProductServiceImp productService = new ProductServiceImp();
	PageModel pm = productService.findProductsByCidWithPage(cid,curPage);
	request.setAttribute("page", pm);
	return "/jsp/product_list.jsp";
	}

}
