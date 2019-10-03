package cn.itcast.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Cart;
import cn.itcast.store.domain.CartItem;
import cn.itcast.store.domain.Product;

import cn.itcast.store.service.serviceImp.ProductServiceImp;
import cn.itcast.store.web.base.BaseServlet;

public class CartServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 添加商品到购物车
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//从session中获取购物车,因为http是无状态的。你这次添加了，下次刷新就没了，只能存在session中
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null)//如果没有购物车，之前从来没有购买过
		{
			cart = new Cart();//创建一个购物车
			request.getSession().setAttribute("cart", cart);//放到session中
		}
		//取得数量和商品id
		Integer quantity =Integer.parseInt(request.getParameter("quantity"));
		String pid = request.getParameter("pid");
		//*******添加之前应该先判断购物车里面是有没有的。购物车用一个对象。里面每个商品也定义一个对象*******
		ProductServiceImp productService = new ProductServiceImp();
		//根据商品pid找到商品
		Product product = productService.findProductByPid(pid);
		//获取到购物车商品条目
		CartItem cartItem = new CartItem();
		cartItem.setNum(quantity);
		cartItem.setProduct(product);
		//将商品添加到购物车
		cart.addCartItemtoCar(cartItem);
		response.sendRedirect("/store_v7/jsp/cart.jsp");
		return null;
	}
	/**
	 * 删除某个商品removeCartItem
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public String removeCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//获取pid
		String pid = request.getParameter("pid");
		//删除商品
		cart.removeItemToPid(pid);
		//重定向
		response.sendRedirect("/store_v7/jsp/cart.jsp");
		return null;
	}
	/**
	 * 清空购物车clearCart
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//清空购物车
		cart.removeAllItems();
		//重定向
		response.sendRedirect("/store_v7/jsp/cart.jsp");
		return null;
	}

}


