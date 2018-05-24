package org.proxibanqueV4.spring.service;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.dao.CrudCompteDAO;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.CompteEpargne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceCompte")
public class PrestiBanqueServiceImplCompte implements IPrestiBanqueServiceCompte {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrestiBanqueServiceImplCompte.class);

	@Autowired
	private CrudCompteDAO crudCompteDao;

	@Autowired
	private CrudClientDAO crudClientDao;

	// pr avoir des données ds la bdd
	@PostConstruct
	public void createSomeCompte() {

	}

	// getter setter
	public CrudCompteDAO getCrudCompteDao() {
		return crudCompteDao;
	}

	public void setCrudCompteDao(CrudCompteDAO crudCompteDao) {
		this.crudCompteDao = crudCompteDao;
	}

	// pr avoir des données ds la bdd
	@Override
	public void AssociatedAddCompteE(Client client) {
		LOGGER.info("Associer un compte épargne à un client lors de sa création");
		CompteEpargne epargne = new CompteEpargne(0,"13/01/2016", "particulier", 0);
		client.setCompteEpargne(epargne);
		crudClientDao.save(client);
	}

	@Override
	public void deleteCompte(long numcompte) {
		LOGGER.info("Suppression d'un compte");
		crudCompteDao.delete(numcompte);
	}

	@Override
	public void updateCompte(Compte c) {
		LOGGER.info("Modification des informations contanu dans un compte");
		crudCompteDao.save(c);

	}

	@Override
	public Compte editCompte(long numCompte) {
		LOGGER.info("Afficher un compte");
		return crudCompteDao.findOne(numCompte);
	}
	
	
	

		
	}
	

	
	
	
