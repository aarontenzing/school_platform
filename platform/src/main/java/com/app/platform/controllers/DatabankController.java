package com.app.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.platform.services.BoodschapService;

@Controller
public class DatabankController {
	
	@Autowired
	private BoodschapService boodschapServ;
	
	
}
