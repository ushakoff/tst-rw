package rw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.dao.ProfileDAO;
import rw.model.Profile;
import rw.service.ProfileService;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDAO profileDAO;

	public Profile getProfile(int id) {
		return profileDAO.getProfile(id);
	}
	
	public void updateProfile(Profile profile) {
		profileDAO.updateProfile(profile);
	}

}
