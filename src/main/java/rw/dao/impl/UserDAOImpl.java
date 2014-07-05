package rw.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import rw.dao.UserDAO;
import rw.model.Profile;
import rw.model.Role;
import rw.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {		
		Role role = (Role) getCurrentSession().load(Role.class, 1);  
		user.setRole(role);
		Profile profile = new Profile();
		user.setProfile(profile);
		profile.setUser(user);
		getCurrentSession().save(user);
	}
	
	public User getUser(Integer id) {
		Query query = getCurrentSession().createQuery("from User u where u.id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	public User getUser(String login) {
		Query query = getCurrentSession().createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	public void updateUser(User user) {
		getCurrentSession().update(user);		
	}
	
	public void deleteUser(Integer id) {
		User user = getUser(id);
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list(); 
	}

}
