package org.proxibanqueV4.spring.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * Classe abstraite Compte avec les attributs numCompte, solde, dateOuverture.
 * 
 * @author Morane
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

	public Compte(long numCompte, double solde, String dateOuverture) {
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public Compte(double solde) {
		this.solde = solde;
	}

	public Compte() {
	}

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

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + "]";
	}

}
