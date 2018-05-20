package org.proxibanqueV4.spring.dao;

import org.proxibanqueV4.spring.model.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudGerantDAO extends JpaRepository<Gerant, Long> {

}
