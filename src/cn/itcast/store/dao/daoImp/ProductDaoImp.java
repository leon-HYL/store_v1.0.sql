package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.domain.Product;
import cn.itcast.store.utils.JDBCUtils;

public class ProductDaoImp implements ProductDao {

	//查找最热门商品
	@Override
	public List<Product> selectProductFromIshot() throws SQLException {
		
		String sql = "select pid, pname, market_price, shop_price,pimage from product where is_hot=1 AND pflag=0 ORDER BY pdate DESC LIMIT 0,9";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
		
	}
	//查询最新上架商品
	@Override
	public List<Product> selectNewProduct() throws SQLException {
		
		String sql = "select pid, pname, market_price, shop_price,pimage from product where pflag=0 ORDER BY pdate DESC LIMIT 0,9";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}
	//查询商品的信息
	@Override
	public Product finProductInfoByPid(String pid) throws SQLException {
		String sql = "select pid, pname, market_price, shop_price,pimage, pdesc from product where pid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;
	}
	// 查看商品类别为cid的商品条数
	@Override
	public int findTotalRecordsByCid(String cid) throws SQLException {
		
		String sql = "select count(*) from product where cid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long) qr.query(sql, new ScalarHandler(),cid);
		return num.intValue();
	}
	@Override
	public List<Product> findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws SQLException {
		
		String sql = "select * from product where cid = ? limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param = {cid, startIndex, pageSize};
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), param);
		return list;
	}
	@Override
	public Product findProductByPid(String pid) throws SQLException {
		String sql = "select * from product where pid = ?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;
	}
	@Override
	public int findTotalRecords() throws SQLException {
		String sql = "select count(*) from product";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long) qr.query(sql, new ScalarHandler());
		return num.intValue();
	}
	@Override
	public List<Product> findProductsWithPage(int startIndex, int pageSize) throws SQLException{
		String sql = "select * from product limit ?,?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {startIndex, pageSize};
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),params);
		return list;
	}
	@Override
	public void saveProduct(Product pro) throws SQLException {
		String sql = "insert into product(pid,pname,market_price,shop_price,pimage,pdate,is_hot,pdesc,pflag,cid)values(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {pro.getPid(),pro.getPname(),pro.getMarket_price(),pro.getShop_price(),pro.getPimage(),new Date(),pro.getIs_hot(),pro.getPdesc(),pro.getPflag(),pro.getCid()};
		qr.update(sql, params);
	}

}
