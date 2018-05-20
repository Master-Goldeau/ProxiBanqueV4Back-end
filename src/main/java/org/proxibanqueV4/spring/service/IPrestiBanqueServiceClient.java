package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Client;

public interface IPrestiBanqueServiceClient {
	public void addClient(Client c);

	public List<Client> listClients();

	public void deleteClient(long idClient);

	public Client editClient(long idClient);

	public void updateClient(Client c);


}
