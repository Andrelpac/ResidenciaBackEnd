package org.serratec.backend.ProjetoCrud02.repository;

import java.util.List;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

//	@Query("From AccountEntity a WHERE a.numero = :numero AND a.id = :id")
//	AccountEntity findByNumeroAndId(@Param("numero") Integer numero, @Param("id") Long id );
	
	AccountEntity findByNumeroAndId(Integer numero, Long id);
	
	List<AccountEntity> findByNomeOrderByNumero(String nome);
	
}
