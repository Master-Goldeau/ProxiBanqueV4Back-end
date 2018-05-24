package org.proxibanqueV4.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * Classe Agence L'agence est caractérisée par un idAgence (numéro
 * d'identification) et une date de création. Elle est dirigée par un gérant
 * unique. Le gérant a la responsabilité des conseillers.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */
@Entity
public class Agence {

	@Id
	private String idAgence;
	private String dateCreation;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private Gerant gerant;

	// Constructeurs

	public Agence() {
	}

	public Agence(String idAgence, String dateCreation) {
		this.idAgence = idAgence;
		this.dateCreation = dateCreation;
	}

	// Getter et Setter

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	// toString

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", dateCreation=" + dateCreation + "]";
	}

}
