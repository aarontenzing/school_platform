package com.app.platform.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.platform.model.Bericht;
import com.app.platform.model.Leerkracht;

public interface BerichtRepository extends JpaRepository<Bericht, Integer> {

	List<Bericht> findByPubliekOrderByCreationDateTimeDesc(boolean b);

	List<Bericht> findByZenderOrderByCreationDateTimeDesc(Leerkracht l);
}
