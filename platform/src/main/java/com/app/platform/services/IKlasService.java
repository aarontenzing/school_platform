package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;

public interface IKlasService {

	public List<Leerling> getLeerlingen(String klasId);

	public Klas getKlas(int id);
}
