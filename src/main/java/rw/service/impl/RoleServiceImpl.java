package rw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.dao.RoleDAO;
import rw.model.Role;
import rw.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}
	
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

}
