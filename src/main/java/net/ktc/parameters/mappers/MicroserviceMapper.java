package net.ktc.parameters.mappers;

import net.ktc.parameters.dto.MicroserviceRequestDTO;
import net.ktc.parameters.dto.MicroserviceResponseDTO;
import net.ktc.parameters.entities.Microservice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MicroserviceMapper {
    MicroserviceResponseDTO microserviceToMicroserviceResponseDTO(Microservice microservice);
    Microservice microserviceRequestDTOMicroservice(MicroserviceRequestDTO microserviceRequestDTO);
}
