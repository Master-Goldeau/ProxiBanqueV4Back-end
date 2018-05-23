package org.proxibanqueV4.spring.service;

import org.proxibanqueV4.spring.dao.CrudCompteDAO;
import org.proxibanqueV4.spring.exception.DecouvertException;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.CompteCourant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceAuditVirement")
public class AuditVirementService implements InterfaceVirAudService {

	@Autowired
	private CrudCompteDAO crudCompteDao;

	@Autowired
	private IPrestiBanqueServiceCompte serviceCompte;

	@Override
	public void Virement(long numCompteCrediteur, long numCompteDebiteur, double montant) throws DecouvertException {

		Compte compteDebiteur = serviceCompte.editCompte(numCompteDebiteur);
		Compte compteCrediteur = serviceCompte.editCompte(numCompteCrediteur);

		double decouvertAutorise;

		if (CompteCourant.class.isInstance(compteDebiteur)) {
			decouvertAutorise = -1000;
		} else {
			decouvertAutorise = 0;
		}

		double soldeCompteDebiteur = compteDebiteur.getSolde();
		double soldeCompteCrediteur = compteCrediteur.getSolde();

		if ((soldeCompteDebiteur - montant) > decouvertAutorise) {
			compteDebiteur.setSolde(soldeCompteDebiteur - montant);
			compteCrediteur.setSolde(soldeCompteCrediteur + montant);
			crudCompteDao.save(compteDebiteur);
			crudCompteDao.save(compteCrediteur);
		} else {
			throw new DecouvertException();
		}
	}

	@Override
	public void Audit(long numCompte) {
		// TODO Auto-generated method stub
		Compte compte = serviceCompte.editCompte(numCompte);
		double soldeCompte = compte.getSolde();

		if (soldeCompte < -5000) {
			System.out.println("Warning");
		}

		else {
			System.out.println("Vous n'avez pas de client critique!");
		}
	}
}
