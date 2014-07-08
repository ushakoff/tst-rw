package rw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rw.model.Category;
import rw.model.Detail;
import rw.model.Discount;
import rw.service.CategoryService;
import rw.service.DiscountService;

@Controller
@RequestMapping("/moder/**")
public class ModerController {
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/**", method=RequestMethod.GET)
	public ModelAndView moderPage() {
		return new ModelAndView("moder");
	}
	
	@RequestMapping(value="/discounts", method=RequestMethod.GET) 
	public ModelAndView discountsPage() {
		ModelAndView modelAndView = new ModelAndView("discounts");
		List<Discount> discounts = discountService.getDiscounts();
		modelAndView.addObject("discounts", discounts);
		return modelAndView;
	}
	
	@RequestMapping(value="/discounts/{id}", method=RequestMethod.GET) 
	public ModelAndView discountEdit(@PathVariable Integer id) {		
		Discount discount = discountService.getDiscount(id);
		if (discount == null) {
			return new ModelAndView("redirect:/moder/discounts");
		}
		ModelAndView modelAndView = new ModelAndView("discountEdit");
		modelAndView.addObject("discount", discount);
		return modelAndView;
	}
	
	@RequestMapping(value="/discounts/{id}", method=RequestMethod.POST)
	public ModelAndView discountEditConfirm(@ModelAttribute @Valid Discount discount,
			BindingResult result, ModelAndView modelAndView) {
		if (result.hasErrors()) {
			modelAndView.setViewName("discountEdit");
			return modelAndView;
		}
		if (discount.getPercent() == null) {
			discount.setPercent(0);
		}
		discountService.updateDiscount(discount);
		return new ModelAndView("redirect:/moder/discounts");
	}
	
	@RequestMapping(value="/discounts/create/{id}", method=RequestMethod.GET) 
	public ModelAndView discountCreate(@PathVariable Integer id) {
		Category category = categoryService.getCategory(id);
		if (category == null) {
			return new ModelAndView("redirect:/moder/categories");
		}
		Discount discount = new Discount();
		discount.setCategory(category);
		discount.setDetail(new Detail());
		ModelAndView modelAndView = new ModelAndView("discountCreate");
		modelAndView.addObject("discount", discount);
		return modelAndView;
	}
	
	@RequestMapping(value="/discounts/create", method=RequestMethod.POST)
	public ModelAndView discountCreateConfirm(@ModelAttribute @Valid Discount discount,
			BindingResult result, ModelAndView modelAndView) {
		if (result.hasErrors()) {
			modelAndView.setViewName("discountCreate");
			return modelAndView;
		}
		if (discount.getPercent() == null) {
			discount.setPercent(0);
		}
		discountService.addDiscount(discount);
		return new ModelAndView("redirect:/moder/categories");
	}
	
	@RequestMapping(value="/discounts/delete/{id}", method=RequestMethod.GET) 
	public ModelAndView discountDelete(@PathVariable Integer id) {		
		Discount discount = discountService.getDiscount(id);
		if (discount == null) {
			return new ModelAndView("redirect:/moder/discounts");
		}
		ModelAndView modelAndView = new ModelAndView("discountDelete");
		modelAndView.addObject("discount", discount);
		return modelAndView;
	}
	
	@RequestMapping(value="/discounts/delete/{id}", method=RequestMethod.POST) 
	public ModelAndView discountDeleteConfirm(@PathVariable Integer id) {		
		discountService.deleteDiscount(id);
		return new ModelAndView("redirect:/moder/discounts");
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET) 
	public ModelAndView categoriesPage() {
		ModelAndView modelAndView = new ModelAndView("categories");
		List<Category> categories = categoryService.getCategories();
		modelAndView.addObject("categories", categories);		
		return modelAndView;
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET) 
	public ModelAndView categoryEdit(@PathVariable Integer id) {
		Category category = categoryService.getCategory(id);
		if (category == null) {
			return new ModelAndView("redirect:/moder/categories");
		}
		ModelAndView modelAndView = new ModelAndView("categoryEdit");
		modelAndView.addObject("category", category);
		return modelAndView;
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public ModelAndView categoryEditConfirm(@ModelAttribute @Valid Category category,
			BindingResult result, ModelAndView modelAndView) {
		if (result.hasErrors()) {
			modelAndView.setViewName("categoryEdit");
			Integer currentId = category.getId();
			Category currentCategory = categoryService.getCategory(currentId);
			modelAndView.addObject("category", currentCategory);
			return modelAndView;
		}
		categoryService.updateCategory(category);
		return new ModelAndView("redirect:/moder/categories");
	}
	
	@RequestMapping(value="/categories/create", method=RequestMethod.GET) 
	public ModelAndView categoryCreate() {
		ModelAndView modelAndView = new ModelAndView("categoryCreate");
		Category category = new Category();
		modelAndView.addObject("category", category);
		return modelAndView;
	}
	
	@RequestMapping(value="/categories/create", method=RequestMethod.POST)
	public ModelAndView categoryCreateConfirm(@ModelAttribute @Valid Category category,
			BindingResult result, ModelAndView modelAndView) {
		if (result.hasErrors()) {
			return new ModelAndView("categoryCreate");
		}
		categoryService.addCategory(category);
		return new ModelAndView("redirect:/moder/categories");
	}
	
	@RequestMapping(value="/categories/delete/{id}", method=RequestMethod.GET) 
	public ModelAndView categoryDelete(@PathVariable Integer id) {		
		Category category = categoryService.getCategory(id);
		if (category == null) {
			return new ModelAndView("redirect:/moder/categories");
		}
		ModelAndView modelAndView = new ModelAndView("categoryDelete");
		modelAndView.addObject("category", category);
		return modelAndView;
	}
	
	@RequestMapping(value="/categories/delete/{id}", method=RequestMethod.POST) 
	public ModelAndView categoryDeleteConfirm(@PathVariable Integer id) {		
		categoryService.deleteCategory(id);
		return new ModelAndView("redirect:/moder/categories");
	}
	
}
