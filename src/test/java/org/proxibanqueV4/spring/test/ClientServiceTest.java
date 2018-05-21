package org.proxibanqueV4.spring.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxibanqueV4.spring.config.ApplicationConfig;
import org.proxibanqueV4.spring.dao.CrudClientDAO;
import org.proxibanqueV4.spring.service.PrestiBanqueServiceImplClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class ClientServiceTest {

	@Autowired
	private PrestiBanqueServiceImplClient client;
	
	@Autowired
	private CrudClientDAO crudClientDAO;

	@Test
	public void testClientService() {
		assertNotNull(client);



	}

}
