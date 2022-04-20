package net.ktc.parameters.controllers;

import net.ktc.parameters.dto.ParametersRequestDTO;
import net.ktc.parameters.dto.ParametersResponseDTO;
import net.ktc.parameters.services.ParameterService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ParametersRestController implements IRestController<ParametersRequestDTO, ParametersResponseDTO>{
    private ParameterService parameterService;

    public ParametersRestController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }


    @Override
    @GetMapping(path = "/parameters/{id}")
    public ParametersResponseDTO getOne(@PathVariable(name = "id") String id) {
        return parameterService.getOne(id);
    }

    @Override
    @PostMapping(path = "/parameters")
    public ParametersResponseDTO save(@Valid @RequestBody ParametersRequestDTO parametersRequestDTO) {
        return parameterService.save(parametersRequestDTO);
    }

    @Override
    @PutMapping(path = "/parameters")
    public ParametersResponseDTO update(@Valid @RequestBody ParametersRequestDTO parametersRequestDTO) {
        return parameterService.update(parametersRequestDTO);
    }

    @Override
    @GetMapping(path = "/parameters")
    public List<ParametersResponseDTO> getAll() {
        return parameterService.getAll();
    }

    @Override
    @DeleteMapping(path = "/parameters/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        parameterService.delete(id);
    }
}
