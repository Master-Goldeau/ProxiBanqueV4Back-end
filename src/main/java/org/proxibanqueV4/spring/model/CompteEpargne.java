package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;

/**
 * 
 * Class CompteEpargne qui hérite de la Classe Compte@author Clothilde et Morane
 *
 */

@Entity
public class CompteEpargne extends Compte {

	private double tauxRemuneration;

	public CompteEpargne(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;

	}

	public CompteEpargne() {

	}

	public CompteEpargne(double solde, double tauxRemuneration) {
		super(solde);
		this.tauxRemuneration = tauxRemuneration;
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

}
