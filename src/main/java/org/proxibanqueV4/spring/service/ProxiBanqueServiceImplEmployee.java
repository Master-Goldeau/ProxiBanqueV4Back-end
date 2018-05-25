package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudAgenceDAO;
import org.proxibanqueV4.spring.dao.CrudConseillerDAO;
import org.proxibanqueV4.spring.dao.CrudGerantDAO;

import org.proxibanqueV4.spring.model.Agence;

import org.proxibanqueV4.spring.model.Conseiller;
import org.proxibanqueV4.spring.model.Gerant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implémentation de l'interface Service des employés Proxibanque.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
@Service("serviceEmployee")
public class ProxiBanqueServiceImplEmployee implements IProxiBanqueServiceEmployee {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProxiBanqueServiceImplEmployee.class);

	@Autowired
	private CrudConseillerDAO crudConseillerDao;

	@Autowired
	private CrudGerantDAO crudGerantDao;

	@Autowired
	private CrudAgenceDAO crudAgenceDao;

	// Getter et Setter

	public CrudConseillerDAO getCrudConseillerDao() {
		return crudConseillerDao;
	}

	public void setCrudConseillerDao(CrudConseillerDAO crudConseillerDao) {
		this.crudConseillerDao = crudConseillerDao;
	}

	public CrudGerantDAO getCrudGerantDao() {
		return crudGerantDao;
	}

	public void setCrudGerantDao(CrudGerantDAO crudGerantDao) {
		this.crudGerantDao = crudGerantDao;
	}

	public CrudAgenceDAO getCrudAgenceDao() {
		return crudAgenceDao;
	}

	public void setCrudAgenceDao(CrudAgenceDAO crudAgenceDao) {
		this.crudAgenceDao = crudAgenceDao;
	}

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
		LOGGER.info("La liste des conseillers");
		return crudConseillerDao.findAll();

	}

	@Override
	public void addConseiller(Conseiller conseiller) {
		LOGGER.info("Creation d'un conseiller");
		crudConseillerDao.save(conseiller);

	}

	@Override
	public void addGerant(Gerant gerant) {
		LOGGER.info("Creation d'un gerant");
		crudGerantDao.save(gerant);

	}

	@Override
	public void addAgence(Agence agence) {
		LOGGER.info("Creation d'une agence");
		crudAgenceDao.save(agence);

	}

}
