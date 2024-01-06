package com.app.platform.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerkracht;

public interface LeerkrachtRepository extends JpaRepository<Leerkracht, String>{
	
}
