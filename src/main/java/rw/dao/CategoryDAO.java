package rw.dao;

import java.util.List;

import rw.model.Category;

public interface CategoryDAO {
	
	public Category getCategory(int id);	
	public List<Category> getCategories();

}
