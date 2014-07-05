package rw.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import rw.dao.DetailDAO;
import rw.model.Detail;

@Repository
public class DetailDAOImpl implements DetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Detail getDetail(int id) {
		Query query = getCurrentSession().createQuery("from Detail d where d.id = :id");
		query.setParameter("id", id);
		Detail detail = (Detail) query.uniqueResult();
		return detail;
	}
	
	public void updateDetail(Detail detail) {
		getCurrentSession().update(detail);		
	}
	
}
