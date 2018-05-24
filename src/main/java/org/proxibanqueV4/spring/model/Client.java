package org.proxibanqueV4.spring.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.stereotype.Component;

@Component("client")
@Entity
public class Client extends Personne {

	private String telephone;

	private String adresse;
	private String ville;
	private String codePostal;


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


	

	public Client(String nom, String prenom, String telephone, String adresse, String ville, String codePostal) {
		super(nom, prenom);
		this.telephone = telephone;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
	}




	// getter setter



	public String getTelephone() {
		return telephone;
	}

	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Client [telephone=" + telephone + ", adresse=" + adresse + ", ville=" + ville + ", codePostal="
				+ codePostal + ", conseiller=" + conseiller + ", compteCourant=" + compteCourant + ", compteEpargne="
				+ compteEpargne + ", getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", toString()=" + super.toString() + "]";
	}

	// toString
	
	

}
