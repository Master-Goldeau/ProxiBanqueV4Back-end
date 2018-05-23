package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;

/**
 * 
 * Class CompteEpargne qui h�rite de la Classe Compte@author Clothilde et Morane
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

	public CompteEpargne(double solde, String dateOuverture, String typeCompte, double tauxRemuneration) {
		super(solde, dateOuverture, typeCompte);
		this.tauxRemuneration = tauxRemuneration;
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	@Override
	public String toString() {
		return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + ", getNumCompte()=" + getNumCompte()
				+ ", getSolde()=" + getSolde() + ", getDateOuverture()=" + getDateOuverture() + ", getTypeCompte()="
				+ getTypeCompte() + ", toString()=" + super.toString() + "]";
	}

}
