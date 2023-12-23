package com.app.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/") 
	public String index(){
		return "home.html";
	}
	
	@GetMapping("/home") 
	public String home(){
		return "home.html";
	}
	
	@RequestMapping("/login") 
	public String login(){
		return "login.html";
	}
	
	@GetMapping("/private/berichten")
	public String berichten(){
		return "berichten.html";
	}
	
	@GetMapping("/private/toetsen")
	public String toetsen(){
		return "toetsen.html";
	}
	
	
}
