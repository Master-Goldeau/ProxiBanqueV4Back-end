package org.proxibanqueV4.spring.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.proxibanqueV4.spring.config.ApplicationConfig;
import org.proxibanqueV4.spring.dao.CrudClientDAO;
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
		//Gcl = new PrestiBanqueServiceImplClient();
		Gcl.setCrudClientDao(dao);
	}

	/**
	 * Méthode addClient_Should_add_A_Client() permet de tester la méthode
	 * addClient() du service client
	 */
//	@Test
//	public void addClient_Should_Create_A_Client() {
//		Client client = new Client();
//		when(dao.save(client)).thenReturn(client);
//		assertEquals(Gcl.addClient(client), client);
//		verify(dao).save(client);
//
//	}

    /**
	 * Méthode editClient_Should_edit_A_Client() permet de tester la méthode
	 * editClient() du service client
	 */
	
	@Test
	public void editClient_Should_edit_A_Client() {
		Client client = new Client();
		long id = client.getId();
		when(dao.findOne(id)).thenReturn(client);
		assertEquals(Gcl.editClient(1), client);
		verify(dao).findOne(id);
	}
}
