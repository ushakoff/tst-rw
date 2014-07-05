package rw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rw.model.Category;
import rw.model.Discount;
import rw.service.CategoryService;
import rw.service.DiscountService;

@Controller
@RequestMapping("/**")
public class DiscountController {
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView("main");
		List<Category> categories = categoryService.getCategories();
		modelAndView.addObject("categories", categories);
		List<Discount> discounts = discountService.getDiscounts();
		modelAndView.addObject("discounts", discounts);
		return modelAndView;
	}
		
	@RequestMapping(value="discounts/{id}", method=RequestMethod.GET) 
	public ModelAndView discountPage(@PathVariable Integer id) {
		Discount discount = discountService.getDiscount(id);
		if (discount == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView modelAndView = new ModelAndView("discount");
		modelAndView.addObject("discount", discount);
		return modelAndView;
	}
	
	@RequestMapping(value={"/categories/{id}"}, method=RequestMethod.GET)
	public ModelAndView categoryPage(@PathVariable Integer id) {
		Category category = categoryService.getCategory(id);
		if (category == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView modelAndView = new ModelAndView("category");		
		modelAndView.addObject("category", category);
		return modelAndView;
	}
	
}
