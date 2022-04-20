package net.ktc.parameters.services;

import java.util.List;

public interface Iservice <RequestDTO, ResponseDTO>{
    ResponseDTO getOne(String id);
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO);
    List<ResponseDTO> getAll();
    void delete(String id);
}
