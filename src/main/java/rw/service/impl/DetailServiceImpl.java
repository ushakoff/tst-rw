package rw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.dao.DetailDAO;
import rw.model.Detail;
import rw.service.DetailService;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {
	
	@Autowired
	private DetailDAO detailDAO;

	public Detail getDetail(int id) {
		return detailDAO.getDetail(id);
	}
	
	public void updateDetail(Detail detail) {
		detailDAO.updateDetail(detail);
	}

}
