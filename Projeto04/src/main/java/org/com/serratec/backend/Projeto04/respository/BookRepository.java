package org.com.serratec.backend.Projeto04.respository;

import java.util.List;

import org.com.serratec.backend.Projeto04.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	@Query("FROM BookEntity b ORDER BY :ordem")
	List<BookEntity> findCustom(@Param("ordem") String ordem);

}
