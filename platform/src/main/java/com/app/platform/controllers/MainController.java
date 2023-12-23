package com.app.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/home") 
	public String home(){
		return "home.html";
	}
	
	@GetMapping("/login") 
	public String login(){
		return "home.html";
	}
	
	@GetMapping("/berichten")
	public String berichten(){
		return "berichten.html";
	}
	
	@GetMapping("/toetsen")
	public String toetsen(){
		return "toetsen.html";
	}
}
