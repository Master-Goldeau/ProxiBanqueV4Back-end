package org.proxibanqueV4.spring.dao;

import org.proxibanqueV4.spring.model.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Cette interface permet de persister les gérants de Proxibanque dans la base
 * de données.
 * 
 * @version ProxibanqueV4
 * @author Ozlem Avci, Morane Musa, Etienne Savary, Arnaud Renard
 **/
public interface CrudGerantDAO extends JpaRepository<Gerant, Long> {

}
