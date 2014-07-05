package rw.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import rw.dao.ProfileDAO;
import rw.model.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Profile getProfile(int id) {
		Query query = getCurrentSession().createQuery("from Profile p where p.id = :id");
		query.setParameter("id", id);
		Profile profile = (Profile) query.uniqueResult();
		return profile;
	}
	
	public void updateProfile(Profile profile) {
		getCurrentSession().update(profile);		
	}
	
}
