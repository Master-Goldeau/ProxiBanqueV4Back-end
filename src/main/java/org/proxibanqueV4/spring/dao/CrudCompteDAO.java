package org.proxibanqueV4.spring.dao;



import org.proxibanqueV4.spring.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudCompteDAO extends JpaRepository<Compte, Long> {

}
