package org.proxibanqueV4.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.CompteCourant;
import org.proxibanqueV4.spring.model.CompteEpargne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implémentation de l'interface Service sur les clients.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Service("service")
public class ProxiBanqueServiceImplClient implements IProxiBanqueServiceClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProxiBanqueServiceImplClient.class);

	@Autowired
	private CrudClientDAO crudClientDao;

	// Ajouter des clients à la Base de Données.
	@PostConstruct
	public void createSomeClient() {
		addClient(new Client("Sabanoglu", "Saban", "0201202202", "rue de Paris", "Paris", "010210"));
		addClient(new Client("Davaro", "Memo", "0201202202", "impasse du Four", "Cherbourg", "010210"));
	}

	// Getter et Setter
	public CrudClientDAO getCrudClientDao() {
		return crudClientDao;
	}

	public void setCrudClientDao(CrudClientDAO crudClientDao) {
		this.crudClientDao = crudClientDao;
	}

	// Méthodes

	@Override
	public void addClient(Client c) {
		LOGGER.info("Création d'un client assiocié à un compte courant et un compte épargne");
		c.setCompteEpargne(new CompteEpargne(0,"28/05/2018","particulier", 0.03));
		c.setCompteCourant(new CompteCourant(0, "28/05/2018", "particulier", "visa"));
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
