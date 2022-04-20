package net.ktc.parameters.mappers;

import net.ktc.parameters.dto.ParameterserviceRequestDTO;
import net.ktc.parameters.dto.ParameterserviceResponseDTO;
import net.ktc.parameters.entities.Parameterservice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParameterserviceMapper {
    ParameterserviceResponseDTO parameterserviceToParameterserviceResponseDTO(Parameterservice parameterservice);
    Parameterservice parameterserviceRequestDTOParameterservice(ParameterserviceRequestDTO parameterserviceRequestDTO);
}
