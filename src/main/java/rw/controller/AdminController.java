package rw.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rw.model.DiscCode;
import rw.model.Role;
import rw.model.User;
import rw.service.DiscCodeService;
import rw.service.ProfileService;
import rw.service.RoleService;
import rw.service.UserService;

@Controller
@RequestMapping("/admin/**")
public class AdminController {
	
	private static final String MESSAGE_LOGIN_USED = "admin.login.used";
	
	@Resource
	private Environment env;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DiscCodeService discCodeService;
	
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
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET) 
	public ModelAndView userEdit(@PathVariable Integer id) {		
		User user = userService.getUser(id);
		if (user == null) {
			return new ModelAndView("redirect:/admin/users");
		}
		List<Role> roles = roleService.getRoles();
		ModelAndView modelAndView = new ModelAndView("userEdit");
		modelAndView.addObject("user", user);
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.POST) 
	public ModelAndView userEditConfirm(@ModelAttribute @Valid User user,
			BindingResult result, ModelAndView modelAndView) {
		List<Role> roles = roleService.getRoles();
		if (incorrectLogin(user)) {
			result.rejectValue("login", "", env.getRequiredProperty(MESSAGE_LOGIN_USED));
		}
		if (result.hasErrors()) {
			modelAndView.setViewName("userEdit");
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
		return new ModelAndView("redirect:/admin/users");
	}
	
	@RequestMapping(value="/users/delete/{id}", method=RequestMethod.GET) 
	public ModelAndView userDelete(@PathVariable Integer id) {		
		User user = userService.getUser(id);
		if (user == null) {
			return new ModelAndView("redirect:/admin/users");
		}
		ModelAndView modelAndView = new ModelAndView("userDelete");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/users/delete/{id}", method=RequestMethod.POST) 
	public ModelAndView userDeleteConfirm(@PathVariable Integer id, Principal user) {		
		User tmpUser = userService.getUser(id);
		if (!user.getName().equals(tmpUser.getLogin())) {
			userService.deleteUser(id);
		}
		return new ModelAndView("redirect:/admin/users");
	}
	
	@RequestMapping(value="/codes/delete/{id}", method=RequestMethod.GET)
	public ModelAndView codesPage(@PathVariable Integer id) {
		DiscCode discCode = discCodeService.getDiscCode(id);
		if (discCode == null) {
			return new ModelAndView("redirect:/admin/users");
		}
		User currentUser = discCode.getUser();
		discCodeService.deleteDiscCode(id);
		if (currentUser != null) {
			return new ModelAndView("redirect:/admin/users/" + currentUser.getId());
		}			
		return new ModelAndView("redirect:/admin/users");
	}
	
	private boolean incorrectLogin(User user) {
		String tmpLogin = user.getLogin();
		User tmpUser = userService.getUser(tmpLogin);
		if (tmpUser == null) {
			return false;
		}
		if (tmpUser.getId().intValue() == user.getId().intValue()) {
			return false;
		}
		return true;
	}
	
}
