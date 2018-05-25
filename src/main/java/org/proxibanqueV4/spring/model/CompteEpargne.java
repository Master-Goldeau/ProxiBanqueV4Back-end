package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;

/**
 * Classe fille CompteEpargne qui h�rite de la classe m�re Compte. Un compte
 * �pargne a pour attribut un taux de Remuneration, mais �galement les
 * param�tres de la classe Compte.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Entity
public class CompteEpargne extends Compte {

	private double tauxRemuneration;

	// Constructeurs

	public CompteEpargne(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;

	}

	public CompteEpargne() {

	}

	public CompteEpargne(double solde, String dateOuverture, String typeCompte, double tauxRemuneration) {
		super(solde, dateOuverture, typeCompte);
		this.tauxRemuneration = tauxRemuneration;
	}

	// Getter et Setter

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	// toString

	@Override
	public String toString() {
		return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + ", getNumCompte()=" + getNumCompte()
				+ ", getSolde()=" + getSolde() + ", getDateOuverture()=" + getDateOuverture() + ", getTypeCompte()="
				+ getTypeCompte() + ", toString()=" + super.toString() + "]";
	}

}
