package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.dao.CrudCompteDAO;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.CompteCourant;
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

	@Override
	public void AssociatedAddCompteE(Client client) {
		CompteEpargne epargne = new CompteEpargne(0, 0);
		client.setCompteEpargne(epargne);
		crudClientDao.save(client);
	}

	@Override
	public void deleteCompte(long numcompte) {
		crudCompteDao.delete(numcompte);

	}

	@Override
	public void updateCompte(Compte c) {
		crudCompteDao.save(c);

	}

}
