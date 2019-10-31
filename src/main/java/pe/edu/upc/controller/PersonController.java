package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.model.Person;
import pe.edu.upc.service.PersonService;
import pe.edu.upc.service.UserService;

@Controller
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/new")
	public String newPerson (Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listUsers", userService.getUsers());
		return "/person/person";
	}
	
	@PostMapping("/save")
	public String savePerson(
			@Valid Person person,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("listUsers", userService.getUsers());
			return "/person/person";
		}else {
			if(personService.createPerson(person) > 0) {
				model.addAttribute("message", "Already exists.");
				model.addAttribute("listUsers", userService.getUsers());
				return "/person/person";
			}else {
				model.addAttribute("message", "Succesfully saved.");
				status.setComplete();
			}
		}
		model.addAttribute("listPeople", personService.getPeople());
		return "/person/listPeople";
	}
	
}
