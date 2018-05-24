package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;

/**
 * Classe fille CompteCourant qui hérite de la classe mère Compte. Un compte
 * courant a pour attribut une carte bancaire, mais également les paramètres de
 * la classe Compte.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Entity
public class CompteCourant extends Compte {

	private String carteVisa;

	// Constructeurs

	public CompteCourant() {
	}

	public CompteCourant(double solde, String dateOuverture, String typeCompte, String carteVisa) {
		super(solde, dateOuverture, typeCompte);
		this.carteVisa = carteVisa;
	}

	public CompteCourant(String carteVisa) {
		this.carteVisa = carteVisa;
	}

	// Getter et Setter

	public String getCarteVisa() {
		return carteVisa;
	}

	public void setCarteVisa(String carteVisa) {
		this.carteVisa = carteVisa;
	}

	// toString

	@Override
	public String toString() {
		return "CompteCourant [carteVisa=" + carteVisa + ", getNumCompte()=" + getNumCompte() + ", getSolde()="
				+ getSolde() + ", getDateOuverture()=" + getDateOuverture() + ", getTypeCompte()=" + getTypeCompte()
				+ ", toString()=" + super.toString() + "]";
	}

}
