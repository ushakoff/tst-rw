package rw.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import rw.dao.RoleDAO;
import rw.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
		return role;
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getRoles() {
		return getCurrentSession().createQuery("from Role").list(); 
	}

}
