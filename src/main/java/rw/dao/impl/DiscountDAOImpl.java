package rw.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import rw.dao.DiscountDAO;
import rw.model.Discount;

@Repository
public class DiscountDAOImpl implements DiscountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addDiscount(Discount discount) {		
		/*Role role = (Role) getCurrentSession().load(Role.class, 1);  
		discount.setRole(role);
		Detail detail = new Detail();
		discount.setDetail(detail);
		detail.setDiscount(discount);
		getCurrentSession().save(discount);*/
	}
	
	public Discount getDiscount(Integer id) {
		Query query = getCurrentSession().createQuery("from Discount d where d.id = :id");
		query.setParameter("id", id);
		Discount discount = (Discount) query.uniqueResult();
		return discount;
	}
	
	public void updateDiscount(Discount discount) {
		getCurrentSession().update(discount);		
	}
	
	public void deleteDiscount(Integer id) {
		Discount discount = getDiscount(id);
		if (discount != null) {
			getCurrentSession().delete(discount);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Discount> getDiscounts() {
		return getCurrentSession().createQuery("from Discount").list(); 
	}

}
