package org.proxibanqueV4.spring.service;

import java.util.List;

import org.proxibanqueV4.spring.model.Agence;

import org.proxibanqueV4.spring.model.Conseiller;
import org.proxibanqueV4.spring.model.Gerant;

public interface IPrestiBanqueServiceEmployee {

	public List<Conseiller> listConseillers();

	public void addConseiller(Conseiller conseiller);

	public void addGerant(Gerant gerant);

	public void addAgence(Agence agence);
}
