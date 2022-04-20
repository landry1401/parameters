package net.ktc.parameters.controllers;

import net.ktc.parameters.dto.ParameterserviceRequestDTO;
import net.ktc.parameters.dto.ParameterserviceResponseDTO;
import net.ktc.parameters.services.ParameterserviceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(path = "/api")
public class ParamServiceRestController implements IRestController<ParameterserviceRequestDTO, ParameterserviceResponseDTO>{
    private ParameterserviceService parameterserviceService;

    public ParamServiceRestController(ParameterserviceService parameterserviceService) {
        this.parameterserviceService = parameterserviceService;
    }

    @Override
    @GetMapping(path = "/paramservice/{id}")
    public ParameterserviceResponseDTO getOne(@PathVariable(name = "id") String id) {
        return parameterserviceService.getOne(id);
    }

    @Override
    @PostMapping(path = "/paramservice")
    public ParameterserviceResponseDTO save(@Valid @RequestBody ParameterserviceRequestDTO parameterserviceRequestDTO) {
        return parameterserviceService.save(parameterserviceRequestDTO);
    }

    @Override
    @PutMapping(path = "/paramservice")
    public ParameterserviceResponseDTO update(@Valid @RequestBody ParameterserviceRequestDTO parameterserviceRequestDTO) {
        return parameterserviceService.update(parameterserviceRequestDTO);
    }

    @Override
    @GetMapping(path = "/paramservice")
    public List<ParameterserviceResponseDTO> getAll() {
        return parameterserviceService.getAll();
    }

    @Override
    @DeleteMapping(path = "/paramservice/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        parameterserviceService.delete(id);
    }
}
