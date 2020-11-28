package com.bassem.boot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
}
