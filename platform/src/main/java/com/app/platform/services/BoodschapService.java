package com.app.platform.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Boodschap;
import com.app.platform.model.BoodschapLink;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;
import com.app.platform.repos.*;


@Service
public class BoodschapService implements IBoodschapService{

	@Autowired
	BoodschapRepository boodschapRepo;
	
	@Autowired
	BoodschapLinkRepository boodschapLinkRepo;
	
	
	@Autowired
	BoodschapLinkService boodschapLinkServ;
	
	public void save(Boodschap boodschap) {
		Date date = new Date();
		boodschap.setCreationDateTime(date);
		boodschapRepo.save(boodschap);
	}

	public List<Boodschap> getAllPubliek() {
		return boodschapRepo.findByPubliekOrderByCreationDateTimeDesc(true);
	}
	
	public List<Boodschap> getAllFromSender(Leerkracht l) {
		return boodschapRepo.findByZenderOrderByCreationDateTimeDesc(l);
	}

	public void verzendBericht(Boodschap b) {
		Date date = new Date();
		b.setCreationDateTime(date);
		boodschapRepo.save(b);
		boodschapLinkServ.maakLinks(b);
	}

	public Boodschap getBoodschap(int id) {
		Optional<Boodschap> b = boodschapRepo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}

	public void deleteById(int id) {
		Boodschap b = this.getBoodschap(id);
		if(b == null) {
			return;
		}
		boodschapLinkRepo.deleteAllByBoodschap(b);
		boodschapRepo.deleteById(id);		
	}
}

