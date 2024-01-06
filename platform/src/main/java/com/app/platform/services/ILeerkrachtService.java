package com.app.platform.services;

import java.util.List;

import com.app.platform.model.Leerkracht;

public interface ILeerkrachtService {
	public void save(Leerkracht leerkracht);

	public Leerkracht getLeerkracht(String id);

	public List<Leerkracht> getAll();
}
