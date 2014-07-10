package rw.controller;

import java.security.Principal;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rw.model.DiscCode;
import rw.model.Discount;
import rw.model.Profile;
import rw.model.User;
import rw.service.DiscCodeService;
import rw.service.ProfileService;
import rw.service.UserService;

@Controller
@RequestMapping("/user/**")
public class UserController {
	
	private static final String MESSAGE_PROFILE_SAVE = "user.profile.save";
	
	@Resource
	private Environment env;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private DiscCodeService discCodeService;
	
	@RequestMapping(value="/**", method=RequestMethod.GET)
	public ModelAndView userPage() {
		return new ModelAndView("user");
	}
	
	@RequestMapping(value="/codes", method=RequestMethod.GET)
	public ModelAndView codesPage(Principal user) {
		User authUser = userService.getUser(user.getName());
		ModelAndView modelAndView = new ModelAndView("codes");
		modelAndView.addObject("discCodes", authUser.getDiscCodes());
		return modelAndView;
	}
	
	@RequestMapping(value="/codes", method=RequestMethod.POST)
	public ModelAndView addCodesPage(@ModelAttribute Discount discount, Principal user) {
		User authUser = userService.getUser(user.getName());
		DiscCode discCode = new DiscCode();
		discCode.setCode(generateCode());
		discCode.setUser(authUser);
		discCode.setDiscount(discount);
		discCodeService.addDiscCode(discCode);		
		return new ModelAndView("redirect:/user/codes");
	}
	
	@RequestMapping(value="/codes/delete/{id}", method=RequestMethod.GET)
	public ModelAndView codesPage(@PathVariable Integer id, Principal user) {
		DiscCode discCode = discCodeService.getDiscCode(id);
		if (discCode == null) {
			return new ModelAndView("redirect:/user/codes");
		}
		if (user.getName().equals(discCode.getUser().getLogin())) {
			discCodeService.deleteDiscCode(discCode.getId());
		}
		return new ModelAndView("redirect:/user/codes");
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public ModelAndView profilePage(Principal user) {
		User authUser = userService.getUser(user.getName());
		ModelAndView modelAndView = new ModelAndView("profile");		
		modelAndView.addObject("profile", authUser.getProfile());
		return modelAndView;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public ModelAndView profilePage(@ModelAttribute Profile profile, Principal user) {
		User authUser = userService.getUser(user.getName());
		if (authUser.getId().intValue() != profile.getId().intValue()) {
			return new ModelAndView("redirect:/");
		}
		profileService.updateProfile(profile);
		ModelAndView modelAndView = new ModelAndView("profile");
		modelAndView.addObject("message", env.getRequiredProperty(MESSAGE_PROFILE_SAVE));
		return modelAndView;
	}
	
	private String generateCode() {
		return UUID.randomUUID().toString().toUpperCase().substring(0, 11);
	}
			
}
