package net.ktc.parameters.repositories;

import net.ktc.parameters.entities.Parameterservice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterServiceRepository extends JpaRepository<Parameterservice, String> {
}
