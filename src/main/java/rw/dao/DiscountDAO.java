package rw.dao;

import java.util.List;

import rw.model.Discount;


public interface DiscountDAO {
	
	public Discount getDiscount(Integer id);
	public void addDiscount(Discount discount);
	public void updateDiscount(Discount discount);
	public void deleteDiscount(Integer id);
	public List<Discount> getDiscounts();

}
