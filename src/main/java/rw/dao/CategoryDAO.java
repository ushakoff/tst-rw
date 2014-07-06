package rw.dao;

import java.util.List;

import rw.model.Category;

public interface CategoryDAO {
	
	public Category getCategory(Integer id);
	public void updateCategory(Category category);
	public void deleteCategory(Integer id);
	public List<Category> getCategories();

}
