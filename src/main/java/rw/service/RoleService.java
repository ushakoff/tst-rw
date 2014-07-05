package rw.service;

import java.util.List;

import rw.model.Role;

public interface RoleService {
	
	public Role getRole(int id);
	public List<Role> getRoles();

}
