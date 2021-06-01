package org.serratec.backend.ProjetoCrud02.repository;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
