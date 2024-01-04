package com.app.platform.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.platform.model.Gebruiker;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;


@Service
public class GebruikerService {
	
	@Autowired
	LeerlingService LeerlingServ;
	
	@Autowired
	LeerkrachtService LeerkrachtServ;
	
	
	public Gebruiker getGebruiker(String id) {
		if(id.startsWith("r")) {
			return LeerlingServ.getLeerling(id);
		}
		else if(id.startsWith("d")) {
			return LeerkrachtServ.getLeerkracht(id);
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

		gebruikers_lijst.addAll(LeerlingServ.getAll());
		gebruikers_lijst.addAll(LeerkrachtServ.getAll());
		
		return gebruikers_lijst;
	}
}
