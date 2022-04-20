package net.ktc.parameters.controllers;

import java.util.List;

public interface IRestController <RequestDTO, ResponseDTO>{
    ResponseDTO getOne(String id);
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO);
    List<ResponseDTO> getAll();
    void delete(String id);
}
