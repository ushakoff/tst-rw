package rw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moder/**")
public class ModerController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView moderPage() {
		return new ModelAndView("moder");
	}
	
}
