package com.app.platform.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;
import com.app.platform.services.BerichtService;
import com.app.platform.services.KlasService;
import com.app.platform.services.LeerkrachtService;
import com.app.platform.services.LeerlingService;
import com.app.platform.services.ScoreService;
import com.app.platform.services.ToetsService;

@RestController
public class InitREST {

	@Autowired
	KlasService klasServ;
	
	@Autowired
	LeerkrachtService leerkrachtServ;
	
	@Autowired
	LeerlingService leerlingServ;
	
	@Autowired
	BerichtService berichtServ;
	
	@Autowired
	ToetsService toetsServ;
	
	@Autowired
	ScoreService scoreServ;

	@PutMapping("/api/init")
	public void init() {

		Klas k1 = new Klas();
		Klas k2 = new Klas();
		Klas k3 = new Klas();
		Klas k4 = new Klas();

		Leerling l1 = new Leerling("Jonas", "r1", "r1", k1);
		Leerling l2 = new Leerling("Jannes", "r2", "r2", k1);
		Leerling l3 = new Leerling("Tevon", "r3", "r3", k2);
		Leerling l4 = new Leerling("Aaron", "r4", "r4", k2);
		Leerling l5 = new Leerling("Arthur", "r5", "r5", k3);
		Leerling l6 = new Leerling("Jef", "r6", "r6", k4);
		Leerling l7 = new Leerling("Jessica", "r7", "r7", k4);
		
		Leerkracht d1 = new Leerkracht("Joost Vennekens", "d1", "d1");
		Leerkracht d2 = new Leerkracht("Toon Goedemé", "d2", "d2");
		
		d1.setRol("ROLE_directeur");
		
		d1.addKlas(k1);
		d1.addKlas(k2);
		d1.addKlas(k3);
		d2.addKlas(k4);
		
		klasServ.save(k1);
		klasServ.save(k2);
		klasServ.save(k3);
		klasServ.save(k4);
		
		leerlingServ.save(l1);
		leerlingServ.save(l2);
		leerlingServ.save(l3);
		leerlingServ.save(l4);
		leerlingServ.save(l4);
		leerlingServ.save(l5);
		leerlingServ.save(l6);
		leerlingServ.save(l7);
		
		leerkrachtServ.save(d1);
		leerkrachtServ.save(d2);
	}
	
}