package org.proxibanqueV4.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe fille Gerant Le gérant est unique et dirige une agence. Elle prend
 * pour paramètre un login et un password que le gérant utilisera pour son
 * authentification (prochaine release). Elle prend également les paramètres de
 * sa classe mère Personne.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 *
 */

@Entity
public class Gerant extends Personne {

	private String login;
	private String password;

	// Constructeurs

	public Gerant() {

	}

	public Gerant(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
	}

	// Getter et Setter

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

	// toString

	@Override
	public String toString() {
		return "Gerant [login=" + login + ", password=" + password + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", toString()=" + super.toString() + "]";
	}

}
