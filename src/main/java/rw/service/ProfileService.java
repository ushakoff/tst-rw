package rw.service;

import rw.model.Profile;

public interface ProfileService {
	
	public Profile getProfile(int id);	
	public void updateProfile(Profile profile);
	
}
