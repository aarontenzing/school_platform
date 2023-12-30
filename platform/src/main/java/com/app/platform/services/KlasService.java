package com.app.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.repos.KlasRepository;

@Service
public class KlasService implements IKlasService{
	
	@Autowired
	KlasRepository KlasRepo;

}
