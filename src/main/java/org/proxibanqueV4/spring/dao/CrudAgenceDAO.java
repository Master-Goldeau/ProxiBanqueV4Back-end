package org.proxibanqueV4.spring.dao;



import org.proxibanqueV4.spring.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudAgenceDAO extends JpaRepository<Agence, String> {

	

}
