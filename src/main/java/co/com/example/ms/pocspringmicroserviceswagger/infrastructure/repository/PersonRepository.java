package co.com.example.ms.pocspringmicroserviceswagger.infrastructure.repository;

import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
