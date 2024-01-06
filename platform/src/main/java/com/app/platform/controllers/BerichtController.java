package com.app.platform.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import com.app.platform.services.BerichtService;
import com.app.platform.services.KlasService;
import com.app.platform.model.Bericht;
import com.app.platform.model.BerichtLink;
import com.app.platform.model.Gebruiker;
import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;
import com.app.platform.services.BerichtLinkService;

@Controller
public class BerichtController {

	@Autowired
	private BerichtService berichtServ;

	@Autowired
	private BerichtLinkService berichtLinkServ;
	
	@Autowired
	private KlasService klasServ;
	
	@PostMapping("leerling/leesBericht")
	@ResponseBody
	public void leesBericht(@RequestParam("berichtlink_id") int id) {
		BerichtLink bl = berichtLinkServ.getBerichtLink(id);
		if(bl != null) {
			bl.setGelezen(true);
		}
		berichtLinkServ.save(bl);
	}	

	@GetMapping("/berichten")
	public String berichten(Model model, HttpSession session){
		Gebruiker gebruiker = (Gebruiker) session.getAttribute("gebruiker");
		
		if(gebruiker instanceof Leerling) {
			model.addAttribute("berichtlinks", berichtLinkServ.getAllLinksForUser((Leerling)gebruiker));
			return "berichten/leerling.html";
		}
		
		else if(gebruiker instanceof Leerkracht) {
			model.addAttribute("berichten", berichtServ.getAllFromSender((Leerkracht)gebruiker));
			return "berichten/leerkracht.html";
		}
	
		model.addAttribute("publieke_berichten", berichtServ.getAllPubliek());
		return "berichten/publiek.html";
	}
		
	@GetMapping("/leerkracht/nieuw_bericht")
	public String nieuwBericht() {
		return "berichten/bericht_verzenden.html";
	}
	
	@PostMapping("/leerkracht/verwijderBericht")
	public String verwijderBericht(@RequestParam("bericht_id") int id) {
		berichtServ.deleteById(id);
		return "berichten/leerkracht.html";
	}
	
	@PostMapping("/leerkracht/post_bericht")
	public String nieuwBericht(HttpSession session, @RequestParam Map<String, String> allParams) {
		Leerkracht leerkracht = (Leerkracht) session.getAttribute("gebruiker");;
		String ontvanger = null;
		String bericht = null;
		String titel = null;
		
		Bericht b = new Bericht();
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			switch(entry.getKey()) {
			  case "ontvanger":
				  ontvanger = entry.getValue();
				  break;
			  case "tekst":
				  bericht = entry.getValue();
				  break;
			  case "titel":
				  titel = entry.getValue();
				  break;
			  default:
			}
		}
			
		if(ontvanger == "publiek") {
			b.setPubliek(true);
		}
		else{
			Klas klas = klasServ.getKlas(Integer.parseInt(ontvanger));
			if(klas == null) {
				return "home.html";
			}
			b.setOntvanger(klas);
		}
		b.setZender((Leerkracht) leerkracht);
		b.setTekst(bericht);
		b.setTitel(titel);
		
		berichtServ.verzendBericht(b);
		return "berichten/leerkracht.html";
	}
}
