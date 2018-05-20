package org.proxibanqueV4.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Agence {

	@Id
	private String idAgence;
	private String dateCreation;

	// consturctor
	public Agence() {
	}

	public Agence(String idAgence, String dateCreation) {
		this.idAgence = idAgence;
		this.dateCreation = dateCreation;
	}

	// setter getter
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

	// to string
	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", dateCreation=" + dateCreation + "]";
	}

}
