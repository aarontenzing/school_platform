package com.app.platform.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import com.app.platform.services.BoodschapService;
import com.app.platform.services.GebruikerService;
import com.app.platform.services.KlasService;
import com.app.platform.model.Boodschap;
import com.app.platform.model.BoodschapLink;
import com.app.platform.model.Gebruiker;
import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;
import com.app.platform.services.BoodschapLinkService;

@Controller
public class BoodschapController {

	@Autowired
	private BoodschapService boodschapServ;

	@Autowired
	private BoodschapLinkService boodschapLinkServ;
	
	@Autowired
	private GebruikerService gebruikerServ;
	
	@Autowired
	private KlasService klasServ;
		
	
	@PostMapping("/leesBericht")
	@ResponseBody
	public void leesBericht(@RequestParam("berichtlink_id") int id) {
		BoodschapLink bl = boodschapLinkServ.getBoodschapLink(id);
		if(bl != null) {
			bl.setGelezen(true);
		}
		boodschapLinkServ.save(bl);
	}	



	@GetMapping("/berichten")
	public String berichten(HttpSession session){
		Gebruiker gebruiker = gebruikerServ.getCurrentUser();
		
		session.setAttribute("Gebruiker", gebruiker);
		
		if(gebruiker instanceof Leerling) {
			session.setAttribute("berichtlinks", boodschapLinkServ.getAllLinksForUser((Leerling)gebruiker));
			return "berichten/leerling.html";
		}
		
		else if(gebruiker instanceof Leerkracht) {
			session.setAttribute("berichten", boodschapServ.getAllFromSender((Leerkracht)gebruiker));
			System.out.print(session.getAttribute("berichten"));
			return "berichten/leerkracht.html";
		}
	
		session.setAttribute("Publieke_berichten", boodschapServ.getAllPubliek());
		return "berichten/publiek.html";
		
	}
	
	
	
	@GetMapping("/nieuw_bericht")
	public String nieuwBericht(HttpSession session) {
		
		Gebruiker gebruiker = gebruikerServ.getCurrentUser();
				
		if(gebruiker instanceof Leerkracht) {
			session.setAttribute("Gebruiker", gebruiker);
			return "berichten/bericht_verzenden.html";
		}
		
		return "home.html";
	}
	
	@PostMapping("/verwijderBericht")
	public String verwijderBericht(@RequestParam("bericht_id") int id) {
		Gebruiker gebruiker = gebruikerServ.getCurrentUser();
		if(gebruiker instanceof Leerkracht) {
			boodschapServ.deleteById(id);
			return "berichten/leerkracht.html";
		}
		return "home.html";
	}
	
	
	@PostMapping("/post_bericht")
	public String nieuwBericht(HttpSession session, @RequestParam Map<String, String> allParams) {
		Gebruiker gebruiker = gebruikerServ.getCurrentUser();
		
		if(gebruiker instanceof Leerkracht) {
			String ontvanger = null;
			String bericht = null;
			String titel = null;
			
			
			
			Boodschap b = new Boodschap();
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
			b.setZender((Leerkracht) gebruiker);
			b.setTekst(bericht);
			b.setTitel(titel);
			
			boodschapServ.verzendBericht(b);
			return "berichten/leerkracht.html";
		}
		
		return "home.html";
	}
	
	
}
