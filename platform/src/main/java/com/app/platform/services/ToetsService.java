package com.app.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Leerkracht;
import com.app.platform.model.Toets;
import com.app.platform.repos.ToetsRepository;

@Service
public class ToetsService implements IToetsService {
	
	@Autowired
	ToetsRepository ToetsRepo;
	
	public void writeToets(String vaknaam, String leerkracht_id) {
		Leerkracht obj1 = new Leerkracht(leerkracht_id);
		Toets obj2 = new Toets(vaknaam, obj1);
		ToetsRepo.saveAndFlush(obj2);
	}

}
