package com.app.platform.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.platform.model.Gebruiker;

@Service
public class GebruikerService {
	
	@Autowired
	LeerlingService leerlingServ;
	
	@Autowired
	LeerkrachtService leerkrachtServ;
	
	
	public Gebruiker getGebruiker(String id) {
		if(id.startsWith("r")) {
			return leerlingServ.getLeerling(id);
		}
		else if(id.startsWith("d")) {
			return leerkrachtServ.getLeerkracht(id);
		}
		return null;
	}
	
	public Gebruiker getCurrentUser() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (authentication != null && authentication.isAuthenticated()) {
	    	return this.getGebruiker(authentication.getName());
	    }
	    return null;
	}
	
	public List<Gebruiker> getAllUsers(){	
		List<Gebruiker> gebruikers_lijst = new ArrayList<Gebruiker>();

		gebruikers_lijst.addAll(leerlingServ.getAll());
		gebruikers_lijst.addAll(leerkrachtServ.getAll());
		
		return gebruikers_lijst;
	}
}
