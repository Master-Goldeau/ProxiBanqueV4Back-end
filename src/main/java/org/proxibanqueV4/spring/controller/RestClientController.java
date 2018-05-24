package org.proxibanqueV4.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients", produces = "application/json")
	public List<Client> getAllClients() {
		return service.listClients();
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity<Client> selectOneClient(@PathVariable("idClient") long idClient) {
		Client client = service.editClient(idClient);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/clients/", produces = "application/json")
	public void addClient(@RequestBody Client c) {
		service.addClient(c);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/clients/{idClient}")
	public void removeClient(@PathVariable("idClient") long idClient) {
		service.deleteClient(idClient);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/clients/", produces = "application/json")
	public void modifyClient(@RequestBody Client c) {
		service.updateClient(c);

	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/conseillers/", produces = "application/json")
	public List<Conseiller> getAllConseillers() {
		return serviceEmployee.listConseillers();
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "clients/{idClient}/compteEpargnes/", produces = "application/json")
	public void selectCompteEpargne(@PathVariable("idClient") long idClient) {
		Client client = service.editClient(idClient);
		serviceCompte.AssociatedAddCompteE(client);
	}

//	@CrossOrigin(origins = "*")
//	@GetMapping(value = "/clients/{idClient}/comptes", produces = "application/json")
//	public List<Compte> ListeComptesUnClient(@PathVariable long idClient) {
//		return serviceCompte.listComptesUnClient(idClient);
//	}
//
//	@CrossOrigin(origins = "*")
//	@GetMapping(value = "comptes/{numCompte}")
//	public Compte AfficherCompteNumero(@PathVariable long numCompte) {
//		return serviceCompte.editCompte(numCompte);
//	}
//
//	@CrossOrigin(origins = "*")
//	@DeleteMapping(value = "/clients/{idClient}/comptes")
//	public void removeCompte(@PathVariable("idClient") long idClient) {
//		serviceCompte.deleteCompte(idClient);
//	}

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


	@CrossOrigin(origins = "*")
	@GetMapping(value = "audit/")
	public List<Compte> audit() throws AuditException {
		return serviceAuditVirement.audit();
		
}

}