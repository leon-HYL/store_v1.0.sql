package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Product;

public interface ProductDao {

	public List<Product> selectProductFromIshot()throws SQLException;

	public List<Product> selectNewProduct()throws SQLException;

	public Product finProductInfoByPid(String pid)throws SQLException;

	public int findTotalRecordsByCid(String cid)throws SQLException;

	public List<Product> findProductsByCidWithPage(String cid, int startIndex, int pageSize)throws SQLException;

	public Product findProductByPid(String pid)throws SQLException;

	public int findTotalRecords()throws SQLException;

	public List<Product> findProductsWithPage(int startIndex, int pageSize)throws SQLException;

	public void saveProduct(Product pro)throws SQLException;

}
