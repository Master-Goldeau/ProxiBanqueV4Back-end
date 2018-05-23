package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.dao.CrudCompteDAO;
import org.proxibanqueV4.spring.model.Adresse;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.CompteCourant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class PrestiBanqueServiceImplClient implements IPrestiBanqueServiceClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrestiBanqueServiceImplClient.class);

	@Autowired
	private CrudClientDAO crudClientDao;
	
	@Autowired
	private CrudCompteDAO crudCompteDao;

	// pr avoir des données ds la bdd
	@PostConstruct
	public void createSomeClient() {
		addClient(new Client("Sabanoglu", "Saban", "0201202202", new Adresse(7, "rue de Paris", "Paris")));
		addClient(new Client("Davaro", "Memo", "0201202202", new Adresse(5, "impasse du Four", "Cherbourg")));
	}

	// getter setter
	public CrudClientDAO getCrudClientDao() {
		return crudClientDao;
	}

	public void setCrudClientDao(CrudClientDAO crudClientDao) {
		this.crudClientDao = crudClientDao;
	}

	// meth
	@Override
	public void addClient(Client c) {
		LOGGER.info("Création d'un client assiocié à une compte courant");
		c.setCompteCourant(new CompteCourant(1, "visa"));
		crudClientDao.save(c);

	}

	@Override
	public List<Client> listClients() {
		LOGGER.info("Afficher la liste des clients");
		return crudClientDao.findAll();
	}

	@Override
	public void deleteClient(long idClient) {
		LOGGER.info("Suppression d'un client");
		crudClientDao.delete(idClient);

	}

	@Override
	public Client editClient(long idClient) {
		LOGGER.info("Afficher un client");
		return crudClientDao.findOne(idClient);
	}

	@Override
	public void updateClient(Client c) {
		LOGGER.info("Modifier les information d'un client");
		crudClientDao.save(c);

	}

}

