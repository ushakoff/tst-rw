package rw.dao;

import java.util.List;

import rw.model.Role;

public interface RoleDAO {
	
	public Role getRole(int id);	
	public List<Role> getRoles();

}
