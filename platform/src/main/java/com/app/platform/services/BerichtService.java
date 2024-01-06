package com.app.platform.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Bericht;
import com.app.platform.model.Leerkracht;
import com.app.platform.repos.*;


@Service
public class BerichtService implements IBerichtService{

	@Autowired
	BerichtRepository berichtRepo;
	
	@Autowired
	BerichtLinkRepository berichtLinkRepo;

	@Autowired
	BerichtLinkService berichtLinkServ;
	
	public void save(Bericht bericht) {
		Date date = new Date();
		bericht.setCreationDateTime(date);
		berichtRepo.save(bericht);
	}

	public List<Bericht> getAllPubliek() {
		return berichtRepo.findByPubliekOrderByCreationDateTimeDesc(true);
	}
	
	public List<Bericht> getAllFromSender(Leerkracht l) {
		return berichtRepo.findByZenderOrderByCreationDateTimeDesc(l);
	}

	public void verzendBericht(Bericht b) {
		Date date = new Date();
		b.setCreationDateTime(date);
		berichtRepo.save(b);
		berichtLinkServ.maakLinks(b);
	}

	public Bericht getBericht(int id) {
		Optional<Bericht> b = berichtRepo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}

	public void deleteById(int id) {
		Bericht b = this.getBericht(id);
		if(b == null) {
			return;
		}
		berichtLinkRepo.deleteAllByBericht(b);
		berichtRepo.deleteById(id);		
	}
}

