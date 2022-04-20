package net.ktc.parameters.services;

import net.ktc.parameters.dto.ParameterserviceRequestDTO;
import net.ktc.parameters.dto.ParameterserviceResponseDTO;
import net.ktc.parameters.entities.Parameterservice;
import net.ktc.parameters.exceptions.ConfliException;
import net.ktc.parameters.exceptions.NotFounException;
import net.ktc.parameters.mappers.ParameterserviceMapper;
import net.ktc.parameters.repositories.ParameterServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParameterserviceServiceImpl implements ParameterserviceService {
    private ParameterServiceRepository parameterServiceRepository;
    private ParameterserviceMapper parameterserviceMapper;

    public ParameterserviceServiceImpl(ParameterServiceRepository parameterServiceRepository, ParameterserviceMapper parameterserviceMapper) {
        this.parameterServiceRepository = parameterServiceRepository;
        this.parameterserviceMapper = parameterserviceMapper;
    }

    @Override
    public ParameterserviceResponseDTO getOne(String id) {
        try {
            Parameterservice parameterservice = parameterServiceRepository.findById(id).get();
            return parameterserviceMapper.parameterserviceToParameterserviceResponseDTO(parameterservice);
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public ParameterserviceResponseDTO save(ParameterserviceRequestDTO parameterserviceRequestDTO) {
        try {
            Parameterservice parameterservice = parameterserviceMapper.parameterserviceRequestDTOParameterservice(parameterserviceRequestDTO);
            parameterservice.setId(UUID.randomUUID().toString());
            return parameterserviceMapper.parameterserviceToParameterserviceResponseDTO(parameterServiceRepository.save(parameterservice));

        }catch (Exception e){
            throw new ConfliException(HttpStatus.CONFLICT, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public ParameterserviceResponseDTO update(ParameterserviceRequestDTO parameterserviceRequestDTO) {
        try {
            Parameterservice parameterservice = parameterserviceMapper.parameterserviceRequestDTOParameterservice(parameterserviceRequestDTO);
            return parameterserviceMapper.parameterserviceToParameterserviceResponseDTO(parameterServiceRepository.save(parameterservice));
        }catch (Exception e){
            throw new ConfliException(HttpStatus.CONFLICT, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public List<ParameterserviceResponseDTO> getAll() {
        try {
            List<Parameterservice> parameterservices = parameterServiceRepository.findAll();
            return parameterservices.stream()
                    .map(paramser->parameterserviceMapper.parameterserviceToParameterserviceResponseDTO(paramser))
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public void delete(String id) {
        try {
            parameterServiceRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }
}
