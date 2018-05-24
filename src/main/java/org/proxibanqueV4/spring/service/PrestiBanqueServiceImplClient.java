package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.dao.CrudConseillerDAO;
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
	

	// pr avoir des donn�es ds la bdd
	@PostConstruct
	public void createSomeClient() {
		addClient(new Client("Sabanoglu", "Saban", "0201202202",  "rue de Paris", "Paris", "010210"));
		addClient(new Client("Davaro", "Memo", "0201202202", "impasse du Four", "Cherbourg","010210"));
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
		LOGGER.info("Cr�ation d'un client assioci� � une compte courant");
		c.setCompteCourant(new CompteCourant(0,"13/01/2016", "particulier","visa"));
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
	
//	@Override
//	public List<Client> ListesClientsParConseiller(long id) {
//		return crudClientDao.findByConseiller(id);
//}

}

