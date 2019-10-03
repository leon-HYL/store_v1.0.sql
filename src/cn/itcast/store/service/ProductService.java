package cn.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;

public interface ProductService {

	public List<Product> gethotProduct()throws SQLException;

	public List<Product> getNewProduct()throws SQLException;

	public Product finProductInfoByPid(String pid)throws SQLException;
	public PageModel findProductsByCidWithPage(String cid, int curPage)throws SQLException;
	public Product findProductByPid(String pid)throws SQLException;
	public PageModel findAllProduct(int curNum)throws SQLException;
	public void saveProduct(Product product)throws SQLException;
}
