package rw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.dao.UserDAO;
import rw.model.User;
import rw.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public User getUser(Integer id) {
		return userDAO.getUser(id);
	}
	
	public User getUser(String login) {
		return userDAO.getUser(login);
	}
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user);		
	}
	
	public void deleteUser(Integer id) {
		userDAO.deleteUser(id);
	} 
	
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
