package rw.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rw.model.User;
import rw.service.ProfileService;
import rw.service.UserService;

@Controller
public class SecurityController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam (value = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView("login");
		if (error != null) {
			modelAndView.addObject("error", true);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public ModelAndView accessDeniedPage(Principal user) {
		ModelAndView model = new ModelAndView("403");
		String userName = "";
		if (user != null) {
			userName = user.getName() + ", ";
		}
		model.addObject("msg", "Sorry, " + userName
				+ "you do not have permission to access this page!");
		return model;
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registrationPage() {
		ModelAndView modelAndView = new ModelAndView("registration");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public ModelAndView registrationPage(
			@ModelAttribute("user") @Valid User user, BindingResult result,
			HttpServletRequest request, ModelAndView modelAndView) {		
		if (result.hasErrors()) {
			return modelAndView;
		}		
		if (userIsExists(user.getLogin())) {
			modelAndView.addObject("message", "We're sorry, this login already in use.");
			return modelAndView;
		}
		userService.addUser(user);
		request.getSession();
		autoLogin(user.getLogin());
		modelAndView = new ModelAndView("profile");
		modelAndView.addObject("profile", user.getProfile());
		modelAndView.addObject("message", "Please, fill your profile.");
		return modelAndView;
	}
	
	private boolean userIsExists(String login) {
		if (userService.getUser(login) == null) {
			return false;
		}
		return true;
	}
	
	private void autoLogin(String login) {
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(login);
		Authentication auth =
				new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
														userDetails.getPassword(),
														userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
