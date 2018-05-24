package org.proxibanqueV4.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe fille Conseiller Elle prend pour paramètre un login et un password que
 * le conseiller utilisera pour son authentification (prochaine release). Elle
 * prend également les paramètres de sa classe mère Personne.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Entity
public class Conseiller extends Personne {

	private String login;
	private String password;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "gerant_id")
	private Gerant gerant;

	// Constructeurs

	public Conseiller() {

	}

	public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
	}

	// Getter et Setter

	// public Set<Client> getClientListConseiller() {
	// return clientListConseiller;
	// }
	//
	// public void setClientListConseiller(Set<Client> clientListConseiller) {
	// this.clientListConseiller = clientListConseiller;
	// }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Conseiller [login=" + login + ", password=" + password + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
