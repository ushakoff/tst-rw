package rw.service;

import java.util.List;

import rw.model.Category;

public interface CategoryService {
	
	public Category getCategory(int id);
	public List<Category> getCategories();

}
