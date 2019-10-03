package cn.itcast.store.service;

import java.util.List;

import cn.itcast.store.domain.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory()throws Exception;
	public void addCategory(Category category)throws Exception;
}
