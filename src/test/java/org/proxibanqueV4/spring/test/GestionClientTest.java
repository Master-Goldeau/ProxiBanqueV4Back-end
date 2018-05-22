package org.proxibanqueV4.spring.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.proxibanqueV4.spring.config.ApplicationConfig;
import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.model.Adresse;
import org.proxibanqueV4.spring.model.Client;
import org.proxibanqueV4.spring.service.PrestiBanqueServiceImplClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class GestionClientTest {

	@Mock
	CrudClientDAO dao;

	@Autowired
	private PrestiBanqueServiceImplClient Gcl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Gcl.setCrudClientDao(dao);
	}

	/**
	 * M�thode addClient_Should_add_A_Client() permet de tester la m�thode
	 * addClient() du service client
	 */
	@Test
	public void addClient_Should_add_A_Client() {
		Client client = new Client("julie", "juju", "05020254032", new Adresse(1, "rue de la fi", "ville"));
		Gcl.addClient(client);
	}

	/**
	 * M�thode editClient_Should_edit_A_Client() permet de tester la m�thode
	 * editClient() du service client
	 */

	@Test
	public void editClient_Should_edit_A_Client() {
		Client client = new Client("julie", "juju", "05020254032", new Adresse(1, "rue de la fi", "ville"));
		client.setId(1L);
		when(dao.findOne(1L)).thenReturn(client);
		Client client1 = Gcl.editClient(1L);
		assertEquals(client, client1);
	}

	/**
	 * M�thode deleteClient_Should_add_A_Client() permet de tester la m�thode
	 * deleteClient() du service client
	 */

	@Test
	public void deleteClient_Should_delete_A_Client() {
		Client client = new Client("julie", "juju", "05020254032", new Adresse(1, "rue de la fi", "ville"));
		Gcl.deleteClient(client.getId());
	}
	
	/**
	 * M�thode updateClient_Should_add_A_Client() permet de tester la m�thode
	 * deleteClient() du service client
	 */

	@Test
	public void updateClient_Should_update_A_Client() {
		Client client = new Client("julie", "juju", "05020254032", new Adresse(1, "rue de la fi", "ville"));
		client.setPrenom("Camille");
		Gcl.updateClient(client);
	}
	

	/**
	 * M�thode listClient_Should_list_A_Client() permet de tester la m�thode
	 * listClient() du service client
	 */

	@Test
	public void listClient_Should_list_A_Client() {
		Client client1 = new Client("julie", "juju", "05020254032", new Adresse(1, "rue de la fi", "ville"));
		Client client2 = new Client("julie", "camille", "05020254032", new Adresse(1, "rue de la fi", "ville"));
		List<Client> listClients= new ArrayList<>();
		listClients.add(client1);
		listClients.add(client2);
		Gcl.listClients();
	}

}
