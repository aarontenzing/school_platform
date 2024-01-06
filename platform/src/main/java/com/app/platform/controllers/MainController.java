package com.app.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.platform.model.Gebruiker;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;
import com.app.platform.services.ScoreService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private ScoreService scoreServ;	
	
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
	
	
	@GetMapping("/private/toetsen")
	public String toetsen(HttpSession session, Model model){
		
		Gebruiker gebruiker = (Gebruiker) session.getAttribute("gebruiker");

		if (gebruiker instanceof Leerling) {
			model.addAttribute("scores", scoreServ.findAllByLeerling((Leerling) gebruiker));
			return "/toetsen/toetsen.html";
		}
		
		else if(gebruiker instanceof Leerkracht){
			return "redirect:/leerkracht/toetsen";
		}
		return "redirect:/error";
	}
	
}
