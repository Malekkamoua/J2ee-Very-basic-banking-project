package org.jan.dao;

import org.jan.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationInterface extends JpaRepository<Operation, String>  {
//	@Query("select o from operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
//	public Page<Operation> EnsembleOp(@Param("x")String codeCompte, PageRequest pageRequest);

}
