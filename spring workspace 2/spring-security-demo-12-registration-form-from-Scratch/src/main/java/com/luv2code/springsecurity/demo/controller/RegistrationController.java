package com.luv2code.springsecurity.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("crmUser", new CrmUser());
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser crmUser,
				BindingResult bindingResult,
				Model model
			) {
		String username = crmUser.getUserName();
		// form validation
		if (bindingResult.hasErrors()) {
			return "registration-form";
		}

		// check if user exists
		User existing = userService.findByUserName(username);
		if(existing != null) {
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User name already exists.");
			return "registration-form";
		}
		
		// save to db
		userService.save(crmUser);
		
		return "registration-confirmation";
	}
	
	// pre process every STring form data
	// remove whitespace
	// if string has white space, it will become null
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
