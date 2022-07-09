package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.codingdojo.relationships.models.Ninja;

public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{
	List<Ninja> findAll();
	@Query("SELECT d.name as dojoname, n.firstName, n.lastName FROM Ninja n JOIN n.dojo d ORDER BY d.name DESC")
	Page<Object[]> getAllNinjasWithDojo(Pageable pageable);
}
