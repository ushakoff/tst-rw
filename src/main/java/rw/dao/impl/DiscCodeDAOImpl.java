package rw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import rw.dao.DiscCodeDAO;
import rw.model.DiscCode;

@Repository
public class DiscCodeDAOImpl implements DiscCodeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addDiscCode(DiscCode discCode) {
		getCurrentSession().save(discCode);
	}
	
	public DiscCode getDiscCode(Integer id) {
		Query query = getCurrentSession().createQuery("from DiscCode dc where dc.id = :id");
		query.setParameter("id", id);
		DiscCode discCode = (DiscCode) query.uniqueResult();
		return discCode;
	}
	
	@SuppressWarnings("unchecked")
	public List<DiscCode> getDiscCodesByUserId(Integer id) {
		List<DiscCode> discCodes = new ArrayList<DiscCode>(); 
		Query query = getCurrentSession().createQuery("from DiscCode dc where dc.user.id = :id");
		query.setParameter("id", id);
		discCodes = query.list();
		return discCodes;
	}
	
	public void updateDiscCode(DiscCode discCode) {
		getCurrentSession().update(discCode);		
	}
	
	public void deleteDiscCode(Integer id) {
		DiscCode discCode = getDiscCode(id);
		if (discCode != null) {
			getCurrentSession().delete(discCode);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DiscCode> getDiscCodes() {
		return getCurrentSession().createQuery("from DiscCode").list(); 
	}

}
