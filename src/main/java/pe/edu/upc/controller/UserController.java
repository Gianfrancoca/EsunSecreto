package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.model.User;
import pe.edu.upc.service.UserService;

public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "user/user";
	}
	
	@PostMapping("/save")
	public String saveUser(
			 @Valid User user,
			 BindingResult result,
			 Model model,
			 SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			return "user/user";
		}else {
			if(userService.createUser(user) > 0) {
				model.addAttribute("message", "Already exists.");
			}else {
				model.addAttribute("message", "Succesfully saved.");
				status.setComplete();
			}
		}
		model.addAttribute("listUsers", userService.getUsers());
		return "users/listUsers";
	}
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		try {
			model.addAttribute("user", new User());
			model.addAttribute("listUsers", userService.getUsers());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "users/listUsers";
	}
}
