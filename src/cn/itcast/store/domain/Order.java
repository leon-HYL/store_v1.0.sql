package cn.itcast.store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单表,也就是我们的小票信息
 * @author tangyuan
 *
 * 2019年5月21日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class Order {

	private String oid;//订单编号
	private Date ordertime;//提交订单时间
	private double total;//商品总计
	private int state;//订单状态:0是未完成，1是完成
	private String address;//收获地址
	private String name;//收货人
	private String telephone;//收货人手机号
	
	private User user;//订单表跟用户关联
	
	private List<OrderItem> list = new ArrayList<>();//订单下所有的订单项

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", address="
				+ address + ", name=" + name + ", telephone=" + telephone + ", user=" + user + ", list=" + list + "]";
	}
	
	
	
}
