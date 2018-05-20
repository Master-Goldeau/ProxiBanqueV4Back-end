package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudCompteDAO;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.CompteCourant;
import org.proxibanqueV4.spring.model.CompteEpargne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceCompte")
public class PrestiBanqueServiceImplCompte implements IPrestiBanqueServiceCompte{
	private static final Logger LOGGER = LoggerFactory.getLogger(PrestiBanqueServiceImplCompte.class);

	@Autowired
	private CrudCompteDAO crudCompteDao;

	// pr avoir des données ds la bdd
	@PostConstruct
	public void createSomeCompte() {
		addCompte(new CompteEpargne(1,2));
		addCompte(new CompteCourant(1, "visa"));
	}

	// getter setter
	public CrudCompteDAO getCrudCompteDao() {
		return crudCompteDao;
	}

	public void setCrudCompteDao(CrudCompteDAO crudCompteDao) {
		this.crudCompteDao = crudCompteDao;
	}

	@Override
	public void addCompte(Compte c) {
		crudCompteDao.save(c);
		
	}

	@Override
	public List<Compte> listComptes() {
		LOGGER.debug("lister clients");
		LOGGER.info("information");
		return crudCompteDao.findAll();
	}

	@Override
	public void deleteCompte(long numcompte) {
		crudCompteDao.delete(numcompte);
		
	}

	@Override
	public Compte editCompte(long numcompte) {
		return crudCompteDao.findOne(numcompte);
	}
	

	@Override
	public void updateCcompte(Compte c) {
		crudCompteDao.save(c);
		
	}

}
