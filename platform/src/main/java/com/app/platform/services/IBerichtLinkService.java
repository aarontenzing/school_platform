package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Bericht;
import com.app.platform.model.BerichtLink;
import com.app.platform.model.Leerling;

public interface IBerichtLinkService {
	
	public BerichtLink getBerichtLink(int id);
	
	public void save(BerichtLink bl);
	
	public List<BerichtLink> getAllLinksForUser(Leerling l);

	public void maakLinks(Bericht b);
}
