package kz.yerbolov.restApiSeptember.repositories;


import jakarta.transaction.Transactional;
import kz.yerbolov.restApiSeptember.entities.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permissions, Long> {
    Permissions findAllByRole(String role);
}
