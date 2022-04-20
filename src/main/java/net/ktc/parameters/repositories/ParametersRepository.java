package net.ktc.parameters.repositories;

import net.ktc.parameters.entities.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametersRepository extends JpaRepository<Parameters, String> {
}
