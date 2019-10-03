package cn.itcast.store.service.serviceImp;

import java.util.List;

import cn.itcast.store.dao.daoImp.CategoryDaoImp;
import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.utils.JedisUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

public class CategoryServiceImp implements CategoryService{

	@Override
	public List<Category> getAllCategory() throws Exception {
		
		CategoryDaoImp category = new CategoryDaoImp();
		List<Category> list = category.selectAllCategory();//到数据库中查找
		return list;
	}
	@Override
	public void addCategory(Category category)throws Exception {
		CategoryDaoImp categoryDao = new CategoryDaoImp();
		categoryDao.addCategory(category);
		//当插入数据的时候删除缓存中的allList
		Jedis jedis = JedisUtils.getJedis();
		jedis.del("allList");
		jedis.close();
	}

	
}
