package net.ktc.parameters.mappers;

import net.ktc.parameters.dto.ParametersRequestDTO;
import net.ktc.parameters.dto.ParametersResponseDTO;
import net.ktc.parameters.entities.Parameters;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParametersMapper {
    ParametersResponseDTO parametersToParametersResponseDTO(Parameters parameters);
    Parameters parameterRequestDTOParameters(ParametersRequestDTO parametersRequestDTO);
}
