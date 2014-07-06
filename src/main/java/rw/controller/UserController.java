package rw.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rw.model.Profile;
import rw.model.User;
import rw.service.ProfileService;
import rw.service.UserService;

@Controller
@RequestMapping("/user/**")
public class UserController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value="/**", method=RequestMethod.GET)
	public ModelAndView userPage() {
		return new ModelAndView("user");
	}
	
	@RequestMapping(value="/codes", method=RequestMethod.GET)
	public ModelAndView codesPage(Principal user) {
		User authUser = userService.getUser(user.getName());
		ModelAndView modelAndView = new ModelAndView("codes");
		modelAndView.addObject("profile", authUser.getProfile());
		return modelAndView;
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
		String message = "Profile was successfully saved.";	
		modelAndView.addObject("message", message);
		return modelAndView;
	}
			
}
