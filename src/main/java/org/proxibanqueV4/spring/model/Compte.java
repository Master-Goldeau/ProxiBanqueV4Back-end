package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe mère abstraite Compte. Les deux classes qui héritent de la classe
 * Compte sont : CompteCourant et CompteEpargne. Un compte se caractérise par un
 * numéro de compte, un solde et la date d'ouverture du compte.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	/**
	 * id d'un Compte est numCompte
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numCompte;

	private double solde;

	private String dateOuverture;

	private String typeCompte;

	// Constructeurs

	public Compte(double solde, String dateOuverture, String typeCompte) {
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.typeCompte = typeCompte;
	}

	public Compte(double solde) {
		this.solde = solde;
	}

	public Compte() {
	}

	// Getter et Setter

	public long getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	// toString

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + "]";
	}

}
