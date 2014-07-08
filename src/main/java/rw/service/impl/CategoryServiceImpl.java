package rw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.dao.CategoryDAO;
import rw.model.Category;
import rw.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	public Category getCategory(Integer id) {
		return categoryDAO.getCategory(id);
	}

	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}
	
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}
	
	public void deleteCategory(Integer id) {
		categoryDAO.deleteCategory(id);
	}
	
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}

}
