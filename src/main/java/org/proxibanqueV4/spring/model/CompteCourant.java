package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;

/**
 * Class CompteCourant qui hérite de la Classe Compte
 * 
 * @author
 *
 */

@Entity
public class CompteCourant extends Compte {

	private String carteVisa;

	public CompteCourant() {
	}

	public CompteCourant(double solde, String dateOuverture, String typeCompte, String carteVisa) {
		super(solde, dateOuverture, typeCompte);
		this.carteVisa = carteVisa;
	}

	public CompteCourant(String carteVisa) {
		this.carteVisa = carteVisa;
	}

	public String getCarteVisa() {
		return carteVisa;
	}

	public void setCarteVisa(String carteVisa) {
		this.carteVisa = carteVisa;
	}

	@Override
	public String toString() {
		return "CompteCourant [carteVisa=" + carteVisa + ", getNumCompte()=" + getNumCompte() + ", getSolde()="
				+ getSolde() + ", getDateOuverture()=" + getDateOuverture() + ", getTypeCompte()=" + getTypeCompte()
				+ ", toString()=" + super.toString() + "]";
	}



}
