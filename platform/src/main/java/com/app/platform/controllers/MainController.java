package com.app.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.platform.services.ScoreService;

import jakarta.servlet.ServletContext;

@Controller
public class MainController {
	
	@Autowired
	private ScoreService score;
	
	// Deze attributen zijn overal binnen de webserver toegankelijk 
	@Autowired
	private ServletContext ctx;
	
	// Inside your service or controller class method
	public String getCurrentUsername() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication != null && authentication.isAuthenticated()) {
	        return authentication.getName(); // This retrieves the username
	    }

	    return null; // No authenticated user found
	}
	
	
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
		ctx.setAttribute("scores", score.findLeerling(getCurrentUsername()));
		return "toetsen.html";
	}
	
}
