package turkcell.starbucks.starbucks.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.starbucks.starbucks.entities.EDevlet;

import java.time.LocalDate;

public interface EDevletRepository extends JpaRepository<EDevlet, Integer> {
    boolean existsByNameAndLastNameAndOfDateBirthAndIdentificationNumber
            (String name, String lastName, LocalDate ofDateBirth, String identificationNumber);


}