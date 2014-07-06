package rw.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import rw.dao.CategoryDAO;
import rw.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Category getCategory(Integer id) {
		Query query = getCurrentSession().createQuery("from Category c where c.id = :id");
		query.setParameter("id", id);
		Category category = (Category) query.uniqueResult();
		return category;
	}

	@Override
	public void updateCategory(Category category) {
		getCurrentSession().update(category);
	}
	
	public void deleteCategory(Integer id) {
		Category category = getCategory(id);
		if (category != null) {
			getCurrentSession().delete(category);
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		return getCurrentSession().createQuery("from Category").list(); 
	}

}
