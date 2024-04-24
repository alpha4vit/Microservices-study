package by.gurinovich.fraudservice.repository;

import by.gurinovich.fraudservice.entity.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FraudRepository extends JpaRepository<Fraud, Long> {
    Optional<Fraud> findByCustomerId(UUID customerId);
}
