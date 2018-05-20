package org.proxibanqueV4.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("client")
@Entity
public class Client extends Personne {

	private String telephone;

	@Autowired
	@Embedded
	private Adresse adresse;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name ="conseiller_id")
	private Conseiller conseiller;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private CompteCourant compteCourant;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private CompteEpargne compteEpargne;

	// constructeur

	public Client() {
	}

	public Client(String telephone, Adresse adresse) {
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Client(Adresse adresse) {
		this.adresse = adresse;
	}

	public Client(String nom, String prenom, String telephone, Adresse adresse) {
		super(nom, prenom);
		this.telephone = telephone;
		this.adresse = adresse;
	}
	// getter setter

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	// toString
	@Override
	public String toString() {
		return "Client [telephone=" + telephone + ", adresse=" + adresse + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", toString()=" + super.toString() + "]";
	}

}
