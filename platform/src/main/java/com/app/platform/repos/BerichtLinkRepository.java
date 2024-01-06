package com.app.platform.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.platform.model.Bericht;
import com.app.platform.model.BerichtLink;
import com.app.platform.model.Leerling;

public interface BerichtLinkRepository extends JpaRepository<BerichtLink, Integer>{
		
	List<BerichtLink> findAllByOntvanger(Leerling leering);

	@Transactional
	void deleteAllByBericht(Bericht b);
	
}
