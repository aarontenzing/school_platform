package com.app.platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.platform.repos.LeerkrachtRepository;

@Service
public class LeerkrachtService implements ILeerkrachtService {
	
	@Autowired
	LeerkrachtRepository LeerkrachtRepo;
	

}
