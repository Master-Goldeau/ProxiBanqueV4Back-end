package org.proxibanqueV4.spring.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.proxibanqueV4.spring.config.ApplicationConfig;

import org.proxibanqueV4.spring.dao.CrudCompteDAO;

import org.proxibanqueV4.spring.model.CompteEpargne;
import org.proxibanqueV4.spring.service.PrestiBanqueServiceImplCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class GestionCompteTest {

	@Mock
	CrudCompteDAO dao;

	@Autowired
	private PrestiBanqueServiceImplCompte Gcl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Gcl.setCrudCompteDao(dao);
	}

	/**
	 * Méthode deleteCompte_Should_add_A_Compte() permet de tester la méthode
	 * deleteCompte() du service compte
	 */

	@Test
	public void deleteCompte_Should_delete_A_Compte() {
		CompteEpargne epargne = new CompteEpargne(0,"13/01/2016", "particulier", 0);
		Gcl.deleteCompte(epargne.getNumCompte());
	}

	/**
	 * Méthode updateCompte_Should_update_A_Compte() permet de tester la méthode
	 * updateCompte() du service compte
	 */

	@Test
	public void updateCompte_Should_update_A_Compte() {
		CompteEpargne epargne = new CompteEpargne(0,"13/01/2016", "particulier", 0);
		epargne.setSolde(20);
		Gcl.updateCompte(epargne);
	}

	/**
	 * Méthode editCompte_Should_edit_A_Client() permet de tester la méthode
	 * editCompte() du service client
	 */

	@Test
	public void editCompte_Should_edit_A_Compte() {
		CompteEpargne epargne = new CompteEpargne(0,"13/01/2016", "particulier", 0);
		epargne.setNumCompte(1L);
		when(dao.findOne(1L)).thenReturn(epargne);
		CompteEpargne epargne1= (CompteEpargne) Gcl.editCompte(1L);
		assertEquals(epargne1, epargne);
	}

}
