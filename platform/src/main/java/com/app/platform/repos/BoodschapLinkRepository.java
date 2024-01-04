package com.app.platform.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.platform.model.Boodschap;
import com.app.platform.model.BoodschapLink;
import com.app.platform.model.Leerling;

public interface BoodschapLinkRepository extends JpaRepository<BoodschapLink, Integer>{
		
	List<BoodschapLink> findAllByOntvanger(Leerling leering);

	@Transactional
	void deleteAllByBoodschap(Boodschap b);

}
