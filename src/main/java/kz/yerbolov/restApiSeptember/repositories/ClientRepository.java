package kz.yerbolov.restApiSeptember.repositories;


import jakarta.transaction.Transactional;
import kz.yerbolov.restApiSeptember.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository <Client, Long> {
    Client findAllByEmail(String username);
}
