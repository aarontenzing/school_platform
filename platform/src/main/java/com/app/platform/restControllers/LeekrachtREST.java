package com.app.platform.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.platform.model.Bericht;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Score;
import com.app.platform.model.Toets;
import com.app.platform.services.BerichtService;
import com.app.platform.services.LeerkrachtService;
import com.app.platform.services.ScoreService;
import com.app.platform.services.ToetsService;

@RestController
public class LeekrachtREST {

	@Autowired
	LeerkrachtService leerkrachtServ;
	
	@Autowired
	BerichtService berichtServ;
	
	@Autowired
	ToetsService toetsServ;
	
	@Autowired
	ScoreService scoreServ;
	
	//// ALGEMEEN ////
	
	@GetMapping("/api/leerkrachten")
	public List<Leerkracht> getLeerkrachten(){
		return leerkrachtServ.getAll();
	}
	
	@GetMapping("/api/leerkrachten/{leerkracht_id:d\\d+}")
	public Leerkracht getLeerkrachten(@PathVariable("leerkracht_id") String leerkracht_id){
		return leerkrachtServ.getLeerkracht(leerkracht_id);
	}
	

	//// BERICHTEN ////
	
	@GetMapping("/api/leerkrachten/{leerkracht_id:d\\d+}/berichten")
	public List<Bericht> getBerichten(@PathVariable("leerkracht_id") String leerkracht_id){
		Leerkracht l = new Leerkracht(leerkracht_id);
		return berichtServ.getAllFromSender(l);
	}
	
	
	@PostMapping("/api/berichten/nieuw_bericht")
	public void voegToeBericht(@RequestBody Bericht b) {
		berichtServ.save(b);
	}
	
	@DeleteMapping("/api/berichten/verwijder_bericht/{bericht_id:\\d+}")
	public void verwijderBericht(@PathVariable("bericht_id") int bericht_id) {
		berichtServ.deleteById(bericht_id);
	}
	
	//// TOETSEN ////
	
	@GetMapping("/api/leerkrachten/{leerkracht_id:d\\d+}/toetsen")
	public List<Toets> getToetsen(@PathVariable("leerkracht_id") String leerkracht_id){
		Leerkracht l = new Leerkracht(leerkracht_id);
		return toetsServ.getToetsen(l);
	}
	
	@PostMapping("/api/toetsen/nieuwe_toets")
	public void voegToeToets(@RequestBody Toets t) {
		toetsServ.save(t);
	}
	
	//// SCORES ////
	
	@GetMapping("/toetsen/{toets_id:\\d+}/scores")
	public List<Score> getToetsScores(@PathVariable("leerkracht_id") int toets_id){
		Toets t = new Toets(toets_id);
		return scoreServ.findAllByToets(t);
	}
	
	@GetMapping("/api/scores/{score_id:\\\\d+}")
	public Score getScore(@PathVariable("leerkracht_id") int score_id){
		return scoreServ.getById(score_id);
	}
	
	
	@PostMapping("/api/scores/nieuwe_score")
	public void voegToe(@RequestBody Score t) {
		scoreServ.save(t);
	}
	
}