package org.proxibanqueV4.spring.model;




import javax.persistence.Entity;


/**
 * Classe du conseiller ; Prête pour les prochaines itérations du projet
 * 
 * @author
 *
 * 
 */

@Entity
public class Conseiller extends Personne {

	private String login;
	private String password;

//	@OneToMany(mappedBy = "conseiller")
//	private Set<Client> clientListConseiller = new HashSet<>();

	// constructor
	public Conseiller() {

	}

	public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
	}

	// getter et setter

//	public Set<Client> getClientListConseiller() {
//		return clientListConseiller;
//	}
//
//	public void setClientListConseiller(Set<Client> clientListConseiller) {
//		this.clientListConseiller = clientListConseiller;
//	}

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

	@Override
	public String toString() {
		return "Conseiller [login=" + login + ", password=" + password + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
