package com.app.platform.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import com.app.platform.model.Leerkracht;

public interface LeerkrachtRepository extends JpaRepository<Leerkracht, String>{
	
}
