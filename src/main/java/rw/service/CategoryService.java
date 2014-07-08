package rw.service;

import java.util.List;

import rw.model.Category;

public interface CategoryService {
	
	public Category getCategory(Integer id);
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Integer id);
	public List<Category> getCategories();

}
