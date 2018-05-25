package org.proxibanqueV4.spring.controller;

import java.util.List;

import org.proxibanqueV4.spring.exception.AuditException;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.Conseiller;
import org.proxibanqueV4.spring.service.IProxiBanqueServiceClient;
import org.proxibanqueV4.spring.service.IProxiBanqueServiceCompte;
import org.proxibanqueV4.spring.service.IProxiBanqueServiceEmployee;
import org.proxibanqueV4.spring.service.InterfaceVirAudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe WebService. La classe WebService fait appel aux méthodes du package
 * Service. Les méthodes de cette classe retournent des réponses HTTP.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 **/
@RestController
public class WebService {

	@Autowired
	IProxiBanqueServiceClient service;

	@Autowired
	IProxiBanqueServiceCompte serviceCompte;

	@Autowired
	IProxiBanqueServiceEmployee serviceEmployee;

	@Autowired
	InterfaceVirAudService serviceAuditVirement;

	/**
	 * GET Récupérer l'ensemble des clients.
	 * 
	 * @return List<Client>
	 */
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients", produces = "application/json")
	public List<Client> getAllClients() {
		return service.listClients();
	}

	/**
	 * GET Récupérer un client via son id.
	 * 
	 * @param idClient
	 * @return ResponseEntity<Client>
	 */
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity<Client> selectOneClient(@PathVariable("idClient") long idClient) {
		Client client = service.editClient(idClient);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	/**
	 * POST Ajouter un client.
	 * 
	 * @param c
	 */
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/clients/", produces = "application/json")
	public void addClient(@RequestBody Client c) {
		service.addClient(c);
	}

	/**
	 * DELETE Supprimer un client via son id.
	 * 
	 * @param idClient
	 */
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/clients/{idClient}")
	public void removeClient(@PathVariable("idClient") long idClient) {
		service.deleteClient(idClient);
	}

	/**
	 * PUT Mettre-à-jour un client.
	 * 
	 * @param c
	 */
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/clients/", produces = "application/json")
	public void modifyClient(@RequestBody Client c) {
		service.updateClient(c);

	}

	/**
	 * GET Récupérer l'ensemble des conseillers.
	 * 
	 * @return List<Conseiller>
	 */
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/conseillers/", produces = "application/json")
	public List<Conseiller> getAllConseillers() {
		return serviceEmployee.listConseillers();
	}

	/**
	 * POST Ajouter un compte Epargne au client venant d'être créé.
	 * 
	 * @param idClient
	 */
	@CrossOrigin(origins = "*")
	@PostMapping(value = "clients/{idClient}/compteEpargnes/", produces = "application/json")
	public void selectCompteEpargne(@PathVariable("idClient") long idClient) {
		Client client = service.editClient(idClient);
		serviceCompte.associatedAddCompteE(client);
	}

	 @CrossOrigin(origins = "*")
	 @GetMapping(value = "/clients/{idClient}/comptes", produces =
	 "application/json")
	 public List<Compte> ListeComptesUnClient(@PathVariable long idClient) {
	 return serviceCompte.listComptesUnClient(idClient);
	 }
	
	 @CrossOrigin(origins = "*")
	 @GetMapping(value = "comptes/{numCompte}")
	 public Compte AfficherCompteNumero(@PathVariable long numCompte) {
	 return serviceCompte.editCompte(numCompte);
	 }
	 


	/**
	 * PUT Effectuer un virement compte à compte.
	 * 
	 * @param numCompteCrediteur
	 * @param numCompteDebiteur
	 * @param montant
	 * @return ResponseEntity<String>
	 **/
	@CrossOrigin(origins = "*")
	@PutMapping(value = "virement/{numCompteDebiteur}/{numCompteCrediteur}/{montant}")
	public ResponseEntity<String> Virement(@PathVariable long numCompteCrediteur, @PathVariable long numCompteDebiteur,
			@PathVariable double montant) {
		try {
			serviceAuditVirement.virement(numCompteCrediteur, numCompteDebiteur, montant);
			return new ResponseEntity<String>("Virement fait!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Virement pas fait!", HttpStatus.NO_CONTENT);
		}

	}

	/**
	 * GET Effectuer un audit des comptes de l'ensemble des clients. Récupérer les
	 * comptes critiques.
	 * 
	 * @return List<Compte>
	 * @throws AuditException
	 */
	@CrossOrigin(origins = "*")
	@GetMapping(value = "audit/")
	public List<Compte> audit() throws AuditException {
		return serviceAuditVirement.audit();

	}

}