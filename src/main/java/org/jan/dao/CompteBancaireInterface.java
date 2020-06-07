package org.jan.dao;

import org.jan.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteBancaireInterface extends JpaRepository<CompteBancaire,String> {

	Object findOne(String nom);

}
