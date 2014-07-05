package rw.controller;

import java.security.Principal;
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

import rw.model.Role;
import rw.model.User;
import rw.service.ProfileService;
import rw.service.RoleService;
import rw.service.UserService;

@Controller
@RequestMapping("/admin/**")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/**", method=RequestMethod.GET)
	public ModelAndView adminPage() {
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/users")
	public ModelAndView usersPage() {
		ModelAndView modelAndView = new ModelAndView("users");		
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@RequestMapping(value="/users/delete/{id}", method=RequestMethod.GET) 
	public ModelAndView deleteUser(@PathVariable Integer id) {		
		User user = userService.getUser(id); 
		if (user == null) {
			return new ModelAndView("redirect:/admin/users");
		}
		ModelAndView modelAndView = new ModelAndView("delete");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/users/delete/{id}", method=RequestMethod.POST) 
	public ModelAndView deleteUser(@PathVariable Integer id, Principal user) {		
		User tmpUser = userService.getUser(id);
		if (!user.getName().equals(tmpUser.getLogin())) {
			userService.deleteUser(id);
		}
		return new ModelAndView("redirect:/admin/users");
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET) 
	public ModelAndView editUser(@PathVariable Integer id) {		
		User user = userService.getUser(id);
		if (user == null) {
			return new ModelAndView("redirect:/admin/users");
		}		
		List<Role> roles = roleService.getRoles();
		ModelAndView modelAndView = new ModelAndView("edit");
		modelAndView.addObject("user", user);
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.POST) 
	public ModelAndView editUser(@ModelAttribute @Valid User user,
			BindingResult result, ModelAndView modelAndView) {
		List<Role> roles = roleService.getRoles();
		if (result.hasErrors()) {
			modelAndView.setViewName("edit");
			modelAndView.addObject("roles", roles);
			return modelAndView;
		}
		int tmpRoleId = user.getRole().getId();
		for (Role role : roles) {
			if (role.getId() == tmpRoleId) {
				user.setRole(role);
			}
		}
		userService.updateUser(user);
		modelAndView = usersPage();
		String message = "User was successfully edited.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
