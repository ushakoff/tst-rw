package rw.dao;

import rw.model.Detail;

public interface DetailDAO {
	
	public Detail getDetail(int id);	
	public void updateDetail(Detail detail);

}
