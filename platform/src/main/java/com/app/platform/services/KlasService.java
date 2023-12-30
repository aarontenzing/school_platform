package com.app.platform.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.model.Leerling;
import com.app.platform.repos.KlasRepository;

@Service
public class KlasService implements IKlasService{
	
	@Autowired
	KlasRepository KlasRepo;
	
	public List<Leerling> getLeerlingen(String klasId) {
		return KlasRepo.findLeerlingenByKlas(klasId);
	}
	
}
