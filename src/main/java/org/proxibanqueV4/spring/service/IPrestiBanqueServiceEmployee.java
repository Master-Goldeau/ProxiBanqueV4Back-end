package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Agence;
import org.proxibanqueV4.spring.model.Conseiller;
import org.proxibanqueV4.spring.model.Gerant;

/**
 * Interface regroupant les opérations sur les différents types d'employés de
 * Proxibanque.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
public interface IPrestiBanqueServiceEmployee {

	/**
	 * Récupérer la liste des conseillers.
	 * 
	 * @return List<Conseiller>
	 */
	public List<Conseiller> listConseillers();

	/**
	 * Ajouter un conseiller.
	 * 
	 * @param conseiller
	 */
	public void addConseiller(Conseiller conseiller);

	/**
	 * Ajouter un gérant.
	 * 
	 * @param gerant
	 */
	public void addGerant(Gerant gerant);

	/**
	 * Ajouter une agence.
	 * 
	 * @param agence
	 */
	public void addAgence(Agence agence);
}
