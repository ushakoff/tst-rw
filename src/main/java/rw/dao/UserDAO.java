package rw.dao;

import java.util.List;

import rw.model.User;

public interface UserDAO {
	
	public User getUser(Integer id);	
	public User getUser(String login);	
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(Integer id);	
	public List<User> getUsers();

}
