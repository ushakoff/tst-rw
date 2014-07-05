package rw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.dao.DiscountDAO;
import rw.model.Discount;
import rw.service.DiscountService;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	private DiscountDAO discountDAO;

	public Discount getDiscount(Integer id) {
		return discountDAO.getDiscount(id);
	}
	
	/*public void addDiscount(Discount discount) {
		discountDAO.addDiscount(discount);
	}
	
	public void updateDiscount(Discount discount) {
		discountDAO.updateDiscount(discount);		
	}
	
	public void deleteDiscount(Integer id) {
		discountDAO.deleteDiscount(id);
	} */
	
	public List<Discount> getDiscounts() {
		return discountDAO.getDiscounts();
	}

}
