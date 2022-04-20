package net.ktc.parameters.services;

import net.ktc.parameters.dto.MicroserviceRequestDTO;
import net.ktc.parameters.dto.MicroserviceResponseDTO;
import net.ktc.parameters.entities.Microservice;
import net.ktc.parameters.exceptions.ConfliException;
import net.ktc.parameters.exceptions.NotFounException;
import net.ktc.parameters.mappers.MicroserviceMapper;
import net.ktc.parameters.repositories.MicroServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class MicroserviceServiceImpl implements MicroserviceService {
    private MicroServiceRepository microServiceRepository;
    private MicroserviceMapper microserviceMapper;

    public MicroserviceServiceImpl(MicroServiceRepository microServiceRepository, MicroserviceMapper microserviceMapper) {
        this.microServiceRepository = microServiceRepository;
        this.microserviceMapper = microserviceMapper;
    }

    @Override
    public MicroserviceResponseDTO getOne(String id) {
        try {
            Microservice microservice = microServiceRepository.findById(id).get();
            return microserviceMapper.microserviceToMicroserviceResponseDTO(microservice);
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public MicroserviceResponseDTO save(MicroserviceRequestDTO microserviceRequestDTO) {
        try {
            Microservice microservice = microserviceMapper.microserviceRequestDTOMicroservice(microserviceRequestDTO);
            microservice.setId(UUID.randomUUID().toString());

            return microserviceMapper.microserviceToMicroserviceResponseDTO(microServiceRepository.save(microservice));
        }catch (Exception e){
            throw new ConfliException(HttpStatus.CONFLICT, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public MicroserviceResponseDTO update(MicroserviceRequestDTO microserviceRequestDTO) {
        try {
            Microservice microservice = microserviceMapper.microserviceRequestDTOMicroservice(microserviceRequestDTO);
            return microserviceMapper.microserviceToMicroserviceResponseDTO(microServiceRepository.save(microservice));
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public List<MicroserviceResponseDTO> getAll() {
        try {
            List<Microservice> microservices = microServiceRepository.findAll();
            return  microservices.stream()
                    .map(microser -> microserviceMapper.microserviceToMicroserviceResponseDTO(microser))
                    .collect(Collectors.toList());

        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }

    @Override
    public void delete(String id) {
        try {
            microServiceRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFounException(HttpStatus.NOT_FOUND, "Erreur " +e.getLocalizedMessage().toString());
        }
    }
}
