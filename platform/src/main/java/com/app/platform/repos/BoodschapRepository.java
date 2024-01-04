package com.app.platform.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.platform.model.Boodschap;
import com.app.platform.model.Leerkracht;
import com.app.platform.model.Leerling;

public interface BoodschapRepository extends JpaRepository<Boodschap, Integer> {

	List<Boodschap> findByPubliekOrderByCreationDateTimeDesc(boolean b);

	List<Boodschap> findByZenderOrderByCreationDateTimeDesc(Leerkracht l);

}
