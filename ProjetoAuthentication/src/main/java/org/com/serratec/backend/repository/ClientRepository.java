package org.com.serratec.backend.repository;

import org.com.serratec.backend.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	ClientEntity findByUsername(String username);

}
