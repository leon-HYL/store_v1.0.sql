package cn.itcast.store.domain;
/**
 * 订单项表
 * @author tangyuan
 *
 * 2019年5月21日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class OrderItem {

	private String itemid;//商品id
	private int quantity;//商品数量
	private double total;//商品小计
	
	private Product product;//订单所关联的商品，外键pid,用对象来存，可以存更多的信息
	private Order order;
	
	
	public String getItemid() {
		return itemid;
	}


	public void setItemid(String itemid) {
		this.itemid = itemid;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", quantity=" + quantity + ", total=" + total + ", product=" + product
				+ ", order=" + order + "]";
	}
	
}
