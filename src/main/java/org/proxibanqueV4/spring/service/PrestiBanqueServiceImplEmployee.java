package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudAgenceDAO;
import org.proxibanqueV4.spring.dao.CrudConseillerDAO;
import org.proxibanqueV4.spring.dao.CrudGerantDAO;
import org.proxibanqueV4.spring.model.Adresse;
import org.proxibanqueV4.spring.model.Agence;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Conseiller;
import org.proxibanqueV4.spring.model.Gerant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceEmployee")
public class PrestiBanqueServiceImplEmployee implements IPrestiBanqueServiceEmployee {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrestiBanqueServiceImplEmployee.class);

	@Autowired
	private CrudConseillerDAO crudConseillerDao;

	@Autowired
	private CrudGerantDAO crudGerantDao;

	@Autowired
	private CrudAgenceDAO crudAgenceDao;

	// // getter setter
	// public CrudClientDAO getCrudClientDao() {
	// return crudClientDao;
	// }
	//
	// public void setCrudClientDao(CrudClientDAO crudClientDao) {
	// this.crudClientDao = crudClientDao;
	// }

	// pr avoir des données ds la bdd
	@PostConstruct
	public void createSomeEmployee() {
		Agence agence = new Agence("51nejd", "12/01/2013");
		Gerant gerant = new Gerant("Foret", "Julie", "gerant1", "gerant1");
		Conseiller conseiller = new Conseiller("David", "Bernard", "conseiller1", "conseiller1");
		agence.setGerant(gerant);
		conseiller.setGerant(gerant);
		addAgence(agence);
		addConseiller(conseiller);
	}

	@Override
	public List<Conseiller> listConseillers() {
		LOGGER.debug("lister conseillers");
		LOGGER.info("information");
		return crudConseillerDao.findAll();

	}

	@Override
	public void addConseiller(Conseiller conseiller) {
		
		crudConseillerDao.save(conseiller);

	}

	@Override
	public void addGerant(Gerant gerant) {
		crudGerantDao.save(gerant);

	}

	@Override
	public void addAgence(Agence agence) {
		crudAgenceDao.save(agence);

	}

}
