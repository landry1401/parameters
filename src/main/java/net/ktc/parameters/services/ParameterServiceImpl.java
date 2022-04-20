package net.ktc.parameters.services;

import net.ktc.parameters.dto.ParametersRequestDTO;
import net.ktc.parameters.dto.ParametersResponseDTO;
import net.ktc.parameters.entities.Parameters;
import net.ktc.parameters.exceptions.ConfliException;
import net.ktc.parameters.exceptions.NotFounException;
import net.ktc.parameters.mappers.ParametersMapper;
import net.ktc.parameters.repositories.ParametersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParameterServiceImpl implements ParameterService {
    private ParametersMapper parametersMapper;
    private ParametersRepository parametersRepository;

    public ParameterServiceImpl(ParametersMapper parametersMapper, ParametersRepository parametersRepository) {
        this.parametersMapper = parametersMapper;
        this.parametersRepository = parametersRepository;
    }

    @Override
    public ParametersResponseDTO getOne(String id) {
        try {
            Parameters parameters = parametersRepository.findById(id).get();
            return parametersMapper.parametersToParametersResponseDTO(parameters);
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public ParametersResponseDTO save(ParametersRequestDTO parametersRequestDTO) {
        try {
            Parameters parameters = parametersMapper.parameterRequestDTOParameters(parametersRequestDTO);
            parameters.setId(UUID.randomUUID().toString());

            return parametersMapper.parametersToParametersResponseDTO(parametersRepository.save(parameters));
        }catch (Exception e){
            throw new ConfliException(HttpStatus.CONFLICT, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public ParametersResponseDTO update(ParametersRequestDTO parametersRequestDTO) {
        try {
            Parameters parameters = parametersMapper.parameterRequestDTOParameters(parametersRequestDTO);
            return parametersMapper.parametersToParametersResponseDTO(parametersRepository.save(parameters));
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public List<ParametersResponseDTO> getAll() {
        try {
         List<Parameters> parameters = parametersRepository.findAll();
         return parameters.stream()
                 .map(params->parametersMapper.parametersToParametersResponseDTO(params))
                 .collect(Collectors.toList());
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public void delete(String id) {
        try {
           parametersRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }
}
