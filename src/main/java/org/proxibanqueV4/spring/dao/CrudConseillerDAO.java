package org.proxibanqueV4.spring.dao;

import org.proxibanqueV4.spring.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudConseillerDAO extends JpaRepository<Conseiller, Long> {

}
