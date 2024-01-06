package com.app.platform.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.platform.model.Leerkracht;
import com.app.platform.services.LeerkrachtService;

@RestController
public class LeekrachtREST {

	@Autowired
	public LeerkrachtService leerkrachtServ;
	
	@GetMapping("/leerkrachten")
	public List<Leerkracht> getLeerkrachten(){
		return leerkrachtServ.getAll();
	}
	
	@GetMapping("/leerkrachten/{leerkracht_id}")
	public Leerkracht getLeerkrachten(@PathVariable("leerkracht_id") String leerkracht_id){
		return leerkrachtServ.getLeerkracht(leerkracht_id);
	}
	
//	@GetMapping("/{leerkracht_id}/klassen")
//	private List<Klas> getLeerkrachtKlassen(@PathVariable("leerkracht_id") String leerkracht_id){
//		return leerkrachtServ.findKlassen_van_leerkrachten("leerkracht_id");
//	}
	
	@GetMapping("/test")
	private String getLeerkrachtKlassen(){
		return "hoi";
	}
}