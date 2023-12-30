package com.app.platform.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;
import com.app.platform.services.KlasService;
import com.app.platform.services.LeerkrachtService;

import jakarta.servlet.ServletContext;

@Controller
public class LeerkrachtController {
	
	@Autowired
	private LeerkrachtService leerkrachtserv;
	
	@Autowired
	private KlasService klasserv;
	
	@Autowired
	private ServletContext ctx;
	
	public String getCurrentUsername() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication != null && authentication.isAuthenticated()) {
	        return authentication.getName(); // This retrieves the username
	    }

	    return null; // No authenticated user found
	}
	
	@GetMapping("/leerkracht/toetsen") 
	public String toetsenBeheer(){
		return "toetsenBeheer";
	}
	
	@GetMapping("/leerkracht/toevoegen") 
	public String toetsenToevoegen(){
		List<Klas> tmp = leerkrachtserv.findKlassen_van_leerkrachten(getCurrentUsername());
		/*
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i).getKlas_id());
		}*/
		
		ctx.setAttribute("leerkracht_klassen", tmp);
		return "toetsenToevoegen";
	}
	
	@GetMapping("/leerkracht/wijzigen") 
	public String toetsenWijzigen(){
		return "toetsenWijzigen";
	}
	
	@PostMapping("/add_toets")
	public String add_toets(@RequestParam("geselecteerde_klas") String klas) {
		System.out.println(klas);
		ctx.setAttribute("geselecteerde_klas", klas);
		// query met op het vinden van leerlingen in klas
		List<Leerling> tmp = klasserv.getLeerlingen(klas);
		
		/*
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i).getNaam());
		}*/
		
		
		
	    return "scoresToevoegen";
	}


}
