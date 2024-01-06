package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Bericht;
import com.app.platform.model.Leerkracht;

public interface IBerichtService {
	
	public void save(Bericht bericht);
	
	public List<Bericht> getAllPubliek();
	
	public List<Bericht> getAllFromSender(Leerkracht l);
	
	public void verzendBericht(Bericht b);
	
	public Bericht getBericht(int id);
	
	public void deleteById(int id);
}
