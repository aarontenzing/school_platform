package com.app.platform.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.platform.model.Klas;
import com.app.platform.model.Leerling;

public interface LeerlingRepository extends JpaRepository<Leerling, String>{

	List<Leerling> findByKlas(Klas klas);

}
