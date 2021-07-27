package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.dto.UserDTO;

import java.util.List;

public interface UserControllerInterface {
    void save(UserDTO user);
    List<UserDTO> getAll();
    void delete (Long userId);
    void put(UserDTO user);
}
