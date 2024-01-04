package com.app.platform.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Boodschap;
import com.app.platform.model.BoodschapLink;
import com.app.platform.model.Leerling;
import com.app.platform.repos.BoodschapLinkRepository;

@Service
public class BoodschapLinkService implements IBoodschapLinkService {

	@Autowired
	BoodschapLinkRepository boodschapLinkRepo;
	
	@Autowired
	LeerlingService leerlingServ;
	
	public BoodschapLink getBoodschapLink(int id) {
		Optional<BoodschapLink> bl = boodschapLinkRepo.findById(id);	
		if(bl.isPresent()) {
			return bl.get();
		}
		return null;
	}
	
	public void save(BoodschapLink bl) {
		boodschapLinkRepo.save(bl);
	}
	
	public List<BoodschapLink> getAllLinksForUser(Leerling l){
		List<BoodschapLink> list = boodschapLinkRepo.findAllByOntvanger(l);
		list.sort((link1, link2)
                  -> link1.getBoodschap().getCreationDateTime().compareTo(
                		  link2.getBoodschap().getCreationDateTime()));
		Collections.reverse(list);
		return list;
	}

	public void maakLinks(Boodschap b) {
		List<Leerling> leerlingLijst = new ArrayList<Leerling>();
		
		if(b.isPubliek()) {
			leerlingLijst = leerlingServ.getAll();
		}
		else {
			leerlingLijst = leerlingServ.getAllFromClass(b.getOntvanger());
		}
	
		for(Leerling leerling : leerlingLijst) {
			BoodschapLink bl = new BoodschapLink(leerling, b);
			boodschapLinkRepo.save(bl);		
		}
	}
}
