package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Client;

/**
 * Interface regroupant les opérations faites par le conseiller sur un client
 * Proxibanque(CRUD). Elle possède également l'opération : récupérer la liste
 * des clients.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
public interface IPrestiBanqueServiceClient {

	/**
	 * Ajouter un client.
	 * 
	 * @param c
	 */
	public void addClient(Client c);

	/**
	 * Générer la liste des clients.
	 * 
	 * @return List<Client>
	 */
	public List<Client> listClients();

	/**
	 * Supprimer un client via son id.
	 * 
	 * @param idClient
	 */
	public void deleteClient(long idClient);

	/**
	 * Récupérer un client via son id.
	 * 
	 * @param idClient
	 * @return Client
	 */
	public Client editClient(long idClient);

	/**
	 * Mettre-à-jour un client.
	 * 
	 * @param c
	 */
	public void updateClient(Client c);

}
