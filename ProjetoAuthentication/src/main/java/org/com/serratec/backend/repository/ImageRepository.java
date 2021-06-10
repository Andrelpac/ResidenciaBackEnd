package org.com.serratec.backend.repository;

import org.com.serratec.backend.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Imagem, Long>{

	Imagem findByClientId(Long id);

}
