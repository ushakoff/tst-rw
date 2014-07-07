package rw.service;

import java.util.List;

import rw.model.DiscCode;

public interface DiscCodeService {
	
	public DiscCode getDiscCode(Integer id);
	public List<DiscCode> getDiscCodesByUserId(Integer id);
	public void addDiscCode(DiscCode discCode);
	public void updateDiscCode(DiscCode discCode);
	public void deleteDiscCode(Integer id);
	public List<DiscCode> getDiscCodes();

}
