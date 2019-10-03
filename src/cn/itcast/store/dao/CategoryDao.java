package cn.itcast.store.dao;

import java.util.List;

import cn.itcast.store.domain.Category;

public interface CategoryDao {

	public List<Category> selectAllCategory() throws Exception;
	public void addCategory(Category category)throws Exception;
}
