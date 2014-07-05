package rw.dao;

import rw.model.Profile;

public interface ProfileDAO {
	
	public Profile getProfile(int id);	
	public void updateProfile(Profile profile);

}
