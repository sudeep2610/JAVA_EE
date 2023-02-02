package org.fi.allcompleterestboot.repositories;

import java.util.Optional;

import org.fi.allcompleterestboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	

}
