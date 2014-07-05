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

	public Category getCategory(int id) {
		return categoryDAO.getCategory(id);
	}
	
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}

}
