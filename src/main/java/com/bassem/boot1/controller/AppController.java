package com.bassem.boot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bassem.boot1.model.Book;
import com.bassem.boot1.repository.IBookRepository;

@Controller
public class AppController {
	
	@Autowired
	IBookRepository iBRepo;
	
	@GetMapping("/home")
	public String home(Model m) {
		
		List<Book> books = iBRepo.findAll();
		m.addAttribute("books", books);
		return "home";
	}
	
	@GetMapping("/del/{id}")
	public String del(Model m, @PathVariable("id") Integer id) {
		iBRepo.deleteById(id);
		return "redirect:/home";
	}
	
	@GetMapping("/addBook")
	public String add(Model m) {
		Book book = new Book();
		m.addAttribute("bk", book);
		return "addBook";
	}
	
	@PostMapping("/saveBook")
	public String save(Model m, @ModelAttribute("bk") Book bk) {
		iBRepo.save(bk);
		return "redirect:/home";
		
	}
	
	@GetMapping("/access-denied")
	public String denied(Model m) {
		return "accessDenied";
		
	}
	
	@RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String authenticate(Model m, 
			@RequestParam(value="error", required = false) String error, 
			@RequestParam(value="logout", required = false) String logout) {
		
		String alert = null;
		String alert_style = null;
		
		if (error != null) {
			alert = "username or password not correct!";
			alert_style = "danger";
		} else if (logout != null) {
			alert = "You have signed out";
			alert_style = "success";
		}
		
		m.addAttribute("alert", alert);
		m.addAttribute("alert_style", alert_style);
		
		return "login";
	}
	
	
	
	
	
}
