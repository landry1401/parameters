package net.ktc.parameters.controllers;

import net.ktc.parameters.dto.MicroserviceRequestDTO;
import net.ktc.parameters.dto.MicroserviceResponseDTO;
import net.ktc.parameters.services.MicroserviceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MicroserviceRestController implements IRestController<MicroserviceRequestDTO, MicroserviceResponseDTO>{
    private MicroserviceService microserviceService;

    public MicroserviceRestController(MicroserviceService microserviceService) {
        this.microserviceService = microserviceService;
    }

    @Override
    @GetMapping(path = "/microservice/{id}")
    public MicroserviceResponseDTO getOne(@PathVariable(name = "id") String id) {
        return microserviceService.getOne(id);
    }

    @Override
    @PostMapping(path = "/microservice")
    public MicroserviceResponseDTO save(@Valid @RequestBody MicroserviceRequestDTO microserviceRequestDTO) {
        return microserviceService.save(microserviceRequestDTO);
    }

    @Override
    @PutMapping(path = "/microservice")
    public MicroserviceResponseDTO update(@Valid @RequestBody MicroserviceRequestDTO microserviceRequestDTO) {
        return microserviceService.update(microserviceRequestDTO);
    }

    @Override
    @GetMapping(path = "/microservice")
    public List<MicroserviceResponseDTO> getAll() {
        return microserviceService.getAll();
    }

    @Override
    @DeleteMapping(path = "/microservice/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        microserviceService.delete(id);
    }
}
