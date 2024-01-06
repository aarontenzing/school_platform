package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;

public interface ILeerlingService {
	
	public void save(Leerling leerling);

	public Leerling getLeerling(String id);

	public List<Leerling> getAll();
	
	public List<Leerling> getAllFromClass(Klas klas);
}
