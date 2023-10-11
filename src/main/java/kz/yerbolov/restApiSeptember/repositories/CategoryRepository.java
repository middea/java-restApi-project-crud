package kz.yerbolov.restApiSeptember.repositories;

import jakarta.transaction.Transactional;
import kz.yerbolov.restApiSeptember.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findAllById(Long id);
}
