package cn.itcast.store.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * 购物车模型
 * @author tangyuan
 *
 * 2019年5月21日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class Cart {

	private Map<String, CartItem> map = new HashMap<>();//商品条目用一个map来存储
	private double total = 0;//商品总价和积分(这里设置一块钱赠送1积分
	/**
	 * 添加商品到购物车,添加的时候可能用户会添加同一个商品多次，所以
	 * 添加的时候应该判断之前的是否已经存在，如果不存在存到map中，如果
	 * 之前已经添加过的则取出之前的加上相应的值即可
	 * @param cartItem
	 */
	public void addCartItemtoCar(CartItem cartItem){
		String pid = cartItem.getProduct().getPid();//获得商品pid
		if(map.containsKey(pid))
		{
			  int oldNum = map.get(pid).getNum();//取得先前的商品数量
			  int newNum = oldNum + cartItem.getNum();//之前的商品数量加上目前的商品数量
			  map.get(pid).setNum(newNum);//设置成新值
			  
		}else//之前没有买过的，直接存进map
		{
			map.put(pid, cartItem);
		}
	}
	/**
	 * 获取所有商品条目
	 * @return
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	/**
	 * 移除某一个商品条目
	 * @param pid
	 */
	public void removeItemToPid(String pid){
		map.remove(pid);
	}
	/**
	 * 清空购物车
	 */
	public void removeAllItems(){
		map.clear();
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	/**
	 * 计算商品总价和积分
	 * @return
	 */
	public double getTotal() {
		total = 0;
		//获取到map中的所有购物项
		Collection<CartItem> values = map.values();
		//将购物项中的每一个小计相加
		for (CartItem cartItem : values) {
			total += cartItem.getSubTotal();
		}
		return total;
		
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
