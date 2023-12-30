package com.app.platform.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;
import com.app.platform.model.Toets;
import com.app.platform.services.KlasService;
import com.app.platform.services.LeerkrachtService;
import com.app.platform.services.ScoreService;
import com.app.platform.services.ToetsService;

import jakarta.servlet.ServletContext;

@Controller
public class LeerkrachtController {
	
	@Autowired
	private LeerkrachtService leerkrachtserv;
	
	@Autowired
	private KlasService klasserv;
	
	@Autowired 
	private ToetsService toetsserv;
	
	@Autowired
	private ScoreService scoreserv;
	
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
		// lijst met alle leerlingen uit klas
		ctx.setAttribute("leerlingen_lijst", tmp); 
		
		/*
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i).getNaam());
		}*/
	    return "scoresToevoegen";
	}
	
	@PostMapping("/submitScores")
	public String handleSubmitScores(@RequestParam Map<String, String> allParams) {
		
		String vak_naam = null;
		// Alle ingegeven scores per leerling
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			if ("vak_naam".equals(entry.getKey())) {
				vak_naam = entry.getValue();
				break;
			}
        }
		System.out.println(vak_naam);
		// toets aanmaken
		Toets savedToets = toetsserv.writeToets(vak_naam, getCurrentUsername());
		// toets id returnen
		savedToets.getToets_id();
		// scores weg schrijven
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			if ("vak_naam".equals(entry.getKey()) || "_csrf".equals(entry.getKey())) {
				continue;
			}
            String leerling_id = entry.getKey();
            String score = entry.getValue();
            System.out.println("Parameter: " + leerling_id + ", Value: " + score);
            scoreserv.writeScore(Integer.parseInt(score), 0, savedToets, leerling_id);
        }
		
		
		
		return("toetsenBeheer");
	}
	


}
