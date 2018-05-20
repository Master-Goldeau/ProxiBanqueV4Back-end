package org.proxibanqueV4.spring.dao;



import org.proxibanqueV4.spring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudClientDAO extends JpaRepository<Client, Long> {

	

}
