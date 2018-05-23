package org.proxibanqueV4.spring.controller;

import java.util.List;

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

	@GetMapping(value = "/clients", produces = "application/json")
	public List<Client> getAllClients() {
		return service.listClients();
	}

	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity<Client> selectOneClient(@PathVariable("idClient") long idClient) {
        Client client = service.editClient(idClient);
        if (client == null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
	

	@PostMapping(value = "/clients/", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> addClient(@RequestBody Client c) {
		service.addClient(c);
		return new ResponseEntity<String>("Ajouter client", HttpStatus.OK);
	}

	@DeleteMapping(value = "/clients/{idClient}")
	@ResponseBody
	public ResponseEntity<String> removeClient(@PathVariable("idClient") long idClient) {
		service.deleteClient(idClient);
		return new ResponseEntity<String>("Supprimer client", HttpStatus.OK);
	}

	@PutMapping(value = "/clients/", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> modifyClient(@RequestBody Client c) {
		service.updateClient(c);
		return new ResponseEntity<String>("modification client", HttpStatus.OK);
	}

	@GetMapping(value = "/conseillers/", produces = "application/json")
	public List<Conseiller> getAllConseillers() {
		return serviceEmployee.listConseillers();
	}

	@PostMapping(value = "clients/{idClient}/compteEpargnes/", produces = "application/json")
	public ResponseEntity<String> selectCompteEpargne(@PathVariable("idClient") long idClient) {
		Client client = service.editClient(idClient);
		serviceCompte.AssociatedAddCompteE(client);
		return new ResponseEntity<String>("Ajout d'un compte épargne à un client", HttpStatus.OK);
	}

	@PutMapping(value = "virement/{numCompteDebiteur}/{numCompteCrediteur}/{montant}")
	public ResponseEntity<String> Virement(@PathVariable long numCompteCrediteur, @PathVariable long numCompteDebiteur,
			@PathVariable double montant) {
		try {
			serviceAuditVirement.Virement(numCompteCrediteur, numCompteDebiteur, montant);
			return new ResponseEntity<String>("Virement fait!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Virement pas fait!", HttpStatus.NO_CONTENT);
		}

	}

}