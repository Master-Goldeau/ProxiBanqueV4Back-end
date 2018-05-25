package org.proxibanqueV4.spring.dao;

import org.proxibanqueV4.spring.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Cette interface permet de persister les agences Proxibanque dans la base de
 * données
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 **/
public interface CrudAgenceDAO extends JpaRepository<Agence, String> {

}
