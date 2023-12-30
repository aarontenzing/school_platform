package com.app.platform.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Klas;
import com.app.platform.repos.LeerkrachtRepository;

@Service
public class LeerkrachtService implements ILeerkrachtService {
	
	@Autowired
	LeerkrachtRepository LeerkrachtRepo;
	
	public List<Klas> findKlassen_van_leerkrachten(String id) {
		return LeerkrachtRepo.findKlassenByLeerkrachtId(id);
	}

}
