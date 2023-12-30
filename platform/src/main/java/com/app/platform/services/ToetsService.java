package com.app.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.repos.ToetsRepository;

@Service
public class ToetsService implements IToetsService {
	
	@Autowired
	ToetsRepository ToetsRepo;

}
