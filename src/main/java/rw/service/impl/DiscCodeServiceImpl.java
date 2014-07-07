package rw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.dao.DiscCodeDAO;
import rw.model.DiscCode;
import rw.service.DiscCodeService;

@Service
@Transactional
public class DiscCodeServiceImpl implements DiscCodeService {
	
	@Autowired
	private DiscCodeDAO discCodeDAO;

	public DiscCode getDiscCode(Integer id) {
		return discCodeDAO.getDiscCode(id);
	}
	
	public List<DiscCode> getDiscCodesByUserId(Integer id) {
		return discCodeDAO.getDiscCodesByUserId(id);
	}
	
	public void addDiscCode(DiscCode discCode) {
		discCodeDAO.addDiscCode(discCode);
	}
	
	public void updateDiscCode(DiscCode discCode) {
		discCodeDAO.updateDiscCode(discCode);		
	}
	
	public void deleteDiscCode(Integer id) {
		discCodeDAO.deleteDiscCode(id);
	} 
	
	public List<DiscCode> getDiscCodes() {
		return discCodeDAO.getDiscCodes();
	}

}
