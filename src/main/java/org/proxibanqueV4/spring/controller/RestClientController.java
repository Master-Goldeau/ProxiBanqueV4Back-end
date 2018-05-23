package org.proxibanqueV4.spring.controller;

import java.util.List;

import org.proxibanqueV4.spring.exception.AuditException;
import org.proxibanqueV4.spring.exception.DecouvertException;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.CompteEpargne;
import org.proxibanqueV4.spring.model.Conseiller;
import org.proxibanqueV4.spring.service.IPrestiBanqueServiceClient;
import org.proxibanqueV4.spring.service.IPrestiBanqueServiceCompte;
import org.proxibanqueV4.spring.service.IPrestiBanqueServiceEmployee;
import org.proxibanqueV4.spring.service.InterfaceVirAudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

	@Autowired
	IPrestiBanqueServiceClient service;

	@Autowired
	IPrestiBanqueServiceCompte serviceCompte;

	@Autowired
	IPrestiBanqueServiceEmployee serviceEmployee;

	@Autowired
	InterfaceVirAudService serviceAuditVirement;

	@GetMapping(value = "/clients", produces = "application/json")
	public List<Client> getAllClients() {
		return service.listClients();
	}

	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public Client selectOneClient(@PathVariable("idClient") long idClient) {
		return service.editClient(idClient);
	}

	@PostMapping(value = "/clients/", produces = "application/json")
	public void addClient(@RequestBody Client c) {
		service.addClient(c);
	}

	@DeleteMapping(value = "/clients/{idClient}")
	public void removeClient(@PathVariable("idClient") long idClient) {
		service.deleteClient(idClient);
	}

	@PutMapping(value = "/clients/", produces = "application/json")
	public void modifyClient(@RequestBody Client c) {
		service.updateClient(c);
	}

	@GetMapping(value = "/conseillers/", produces = "application/json")
	public List<Conseiller> getAllConseillers() {
		return serviceEmployee.listConseillers();
	}

	@PostMapping(value = "clients/{idClient}/compteEpargnes/", produces = "application/json")
	public void selectCompteEpargne(@PathVariable("idClient") long idClient) {
		Client client = service.editClient(idClient);
		serviceCompte.AssociatedAddCompteE(client);

	}

	@PutMapping(value = "virement/{numCompteDebiteur}/{numCompteCrediteur}/{montant}")
	public void virement(@PathVariable long numCompteCrediteur, @PathVariable long numCompteDebiteur,
			@PathVariable double montant) {
		try {
			serviceAuditVirement.virement(numCompteCrediteur, numCompteDebiteur, montant);
		} catch (DecouvertException e) {
			e.printStackTrace();

		}

	}

	@GetMapping(value = "audit/{numCompte}")
	public Compte audit(@PathVariable long numCompte) throws AuditException{	
		if(serviceAuditVirement.audit(numCompte)==true) {
			return null;
		}
		else{
			return serviceCompte.editCompte(numCompte);
		}
		
		
	}
}