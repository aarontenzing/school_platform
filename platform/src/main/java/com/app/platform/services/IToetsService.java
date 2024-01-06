package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Leerkracht;
import com.app.platform.model.Toets;

public interface IToetsService {
	public Toets writeToets(String vaknaam, Leerkracht leerkracht);

	public List<Toets> getToetsen(Leerkracht l);

	public void save(Toets t);

}
