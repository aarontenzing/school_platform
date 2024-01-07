package com.app.platform.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Bericht;
import com.app.platform.model.BerichtLink;
import com.app.platform.model.Leerling;
import com.app.platform.repos.BerichtLinkRepository;

@Service
public class BerichtLinkService implements IBerichtLinkService {

	@Autowired
	BerichtLinkRepository berichtLinkRepo;
	
	@Autowired
	LeerlingService leerlingServ;
	
	public BerichtLink getBerichtLink(int id) {
		Optional<BerichtLink> bl = berichtLinkRepo.findById(id);	
		if(bl.isPresent()) {
			return bl.get();
		}
		return null;
	}
	
	public void save(BerichtLink bl) {
		berichtLinkRepo.save(bl);
	}
	
	public List<BerichtLink> getAllLinksForUser(Leerling l){
		List<BerichtLink> list = berichtLinkRepo.findAllByOntvanger(l);
		list.sort((link1, link2)
                  -> link1.getBericht().getCreationDateTime().compareTo(
                		  link2.getBericht().getCreationDateTime()));
		Collections.reverse(list);
		return list;
	}

	public void maakLinks(Bericht b) {
		List<Leerling> leerlingLijst = new ArrayList<Leerling>();
		
		if(b.isPubliek()) {
			leerlingLijst = leerlingServ.getAll();
		}
		else {
			leerlingLijst = leerlingServ.getAllFromClass(b.getOntvanger());
		}
	
		for(Leerling leerling : leerlingLijst) {
			BerichtLink bl = new BerichtLink(leerling, b);
			berichtLinkRepo.save(bl);		
		}
	}

}
