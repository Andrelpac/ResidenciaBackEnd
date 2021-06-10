package org.com.serratec.backend.repository;

import org.com.serratec.backend.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

	ImageEntity findByClientId(Long id);

}
