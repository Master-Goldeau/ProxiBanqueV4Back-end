package org.proxibanqueV4.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.proxibanqueV4.spring.dao.CrudCompteDAO;
import org.proxibanqueV4.spring.exception.AuditException;
import org.proxibanqueV4.spring.exception.DecouvertException;
import org.proxibanqueV4.spring.model.Compte;
import org.proxibanqueV4.spring.model.CompteCourant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceAuditVirement")
public class AuditVirementService implements InterfaceVirAudService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuditVirementService.class);
	@Autowired
	private CrudCompteDAO crudCompteDao;

	@Autowired
	private IPrestiBanqueServiceCompte serviceCompte;

	@Override
	public void virement(long numCompteCrediteur, long numCompteDebiteur, double montant) throws DecouvertException {

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
	public List<Compte> audit() throws AuditException {
		List<Compte> listTousLesComptes = crudCompteDao.findAll();
		List<Compte> listTousLesComptesCritiques = new ArrayList<>();
		double auditAutorise;

		for (Compte compte : listTousLesComptes) {
			if (compte.getTypeCompte().equals("particulier")) {
				auditAutorise = -5000;
			} else if (compte.getTypeCompte().equals("entreprise")) {
				auditAutorise = -50000;
			} else {
				throw new AuditException();
			}
			if (compte.getSolde() < auditAutorise) {
				LOGGER.info("Warning");
				listTousLesComptesCritiques.add(compte);
			}

			else {
				LOGGER.info("Ce client n'est pas un compte critique!");
			}

		}
		return listTousLesComptesCritiques;
	}
}
