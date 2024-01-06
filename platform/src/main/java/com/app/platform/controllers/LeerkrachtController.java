package com.app.platform.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.platform.model.Gebruiker;
import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;
import com.app.platform.forms.MyForm;
import com.app.platform.model.Score;
import com.app.platform.model.Toets;
import com.app.platform.services.KlasService;
import com.app.platform.services.LeerkrachtService;
import com.app.platform.services.LeerlingService;
import com.app.platform.services.ScoreService;
import com.app.platform.services.ToetsService;

import jakarta.servlet.http.HttpSession;

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
	private LeerlingService leerlingServ;
	
	@GetMapping("/leerkracht/toetsen") 
	public String toetsenBeheer(){
		return "toetsen/toetsenBeheer.html";
	}
	
	@GetMapping("/leerkracht/wijzigen") 
	public String toetsenWijzigen(Model mod){
		//Scores ophalen waarbij leerling afwezig was
		MyForm obj = new MyForm(scoreserv.findAfwezigen(1));
		if (obj.getScores().size() == 0) {
			return "toetsen/toetsenbeheer.html";
		}
		mod.addAttribute("myForm", obj);
		return "toetsen/toetsenWijzigen.html";
	}
	
	@PostMapping("/leerkracht/update_score") 
	public String update_score(@ModelAttribute("myForm") MyForm allParams){
		
		for (Score obj : allParams.getScores()) {
			Score old = scoreserv.findByScoreId(obj.getScore_id()); 
		
			if (obj.getScore() > -1) {
				old.setScore(obj.getScore());
				old.setAfwezig(0);
				scoreserv.updateScore(old);
			}
		}		
		return "toetsen/toetsenBeheer";
	}
	
	@GetMapping("/leerkracht/toevoegen") 
	public String toetsenToevoegen(Model model, HttpSession session){
		Leerkracht leerkracht = (Leerkracht) session.getAttribute("gebruiker");

		List<Klas> tmp = leerkracht.getKlassen();
		if (tmp.size() == 0) {
			return "toetsen/toetsenbeheer.html";
		}
		List<Klas> klassen = new ArrayList<Klas>();
		for (Klas klas : tmp) {
			if (klas.getLeerlingen().size() != 0) {
				klassen.add(klas);
			}
			
		}
		System.out.println(klassen);
		model.addAttribute("leerkracht_klassen", klassen);
		return "toetsen/toetsenToevoegen";
	}
	
	@PostMapping("/leerkracht/add_toets")
	public String add_toets(Model model, @RequestParam("geselecteerde_klas") String klas) {
		model.addAttribute("geselecteerde_klas", klas);
		// query met op het vinden van leerlingen in klas
		List<Leerling> tmp = klasserv.getLeerlingen(klas);
		// lijst met alle leerlingen uit klas
		model.addAttribute("leerlingen_lijst", tmp); 
	    return "toetsen/scoresToevoegen";
	}
	
	@PostMapping("/leerkracht/submitScores")
	public String handleSubmitScores(HttpSession session, @RequestParam Map<String, String> allParams) {
		Leerkracht leerkracht = (Leerkracht) session.getAttribute("gebruiker");

		String vak_naam = null;
		// Vak naam verkrijgen uit array
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			if ("vak_naam".equals(entry.getKey())) {
				vak_naam = entry.getValue();
				break;
			}
        }
	
		// Toets aanmaken 
		Toets savedToets = toetsserv.writeToets(vak_naam, leerkracht);
		
		// Scores weg schrijven, door lijst lopen en alle punten krijgen
		Leerling leerling;
		String leerling_id;
		String score;
		String key;
		int isAbsent;
				
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			
			key = entry.getKey();

			if(key.startsWith("Leerling_")) {
				leerling_id = key.replace("Leerling_", "");
				leerling = leerlingServ.getLeerling(leerling_id);
				
				if(entry.getValue().isEmpty()) {
					score = "-1";
					isAbsent = 1;
				}
				else {
			        score = entry.getValue();
			        isAbsent = 0;
				}
				scoreserv.writeScore(Integer.parseInt(score), isAbsent, savedToets, leerling);
			}
            
        }
		return "toetsen/toetsenBeheer";
	}
}
