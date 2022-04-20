package net.ktc.parameters.repositories;

import net.ktc.parameters.entities.Microservice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroServiceRepository extends JpaRepository<Microservice, String> {
}
