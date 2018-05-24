package org.proxibanqueV4.spring.service;

import java.util.ArrayList;
import java.util.List;

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

/**
 * Classe d'implémentation de l'interface Service sur les comptes.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Service("serviceCompte")
public class PrestiBanqueServiceImplCompte implements IPrestiBanqueServiceCompte {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrestiBanqueServiceImplCompte.class);

	@Autowired
	private CrudCompteDAO crudCompteDao;

	@Autowired
	private CrudClientDAO crudClientDao;

	// Ajouter des comptes à la Base de Données.
	@PostConstruct
	public void createSomeCompte() {

	}

	// Getter et setter.
	public CrudCompteDAO getCrudCompteDao() {
		return crudCompteDao;
	}

	public void setCrudCompteDao(CrudCompteDAO crudCompteDao) {
		this.crudCompteDao = crudCompteDao;
	}

	@Override
	public void associatedAddCompteE(Client client) {
		LOGGER.info("Associer un compte épargne à un client lors de sa création");
		CompteEpargne epargne = new CompteEpargne(0, "13/01/2016", "particulier", 0);
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

	@Override
	public List<Compte> listComptesUnClient(long idClient) {
		LOGGER.info("Liste des comptes d'un client");
		Client client = crudClientDao.findOne(idClient);
		List<Compte> listeCompte = new ArrayList<>();
		listeCompte.add(client.getCompteCourant());
		listeCompte.add(client.getCompteEpargne());
		return listeCompte;
	}

}
