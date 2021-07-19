package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface UserControllerInterface {
    void save(UserDTO user);
    List<User> getAll();
    void delete (Long userId);
    void put(UserDTO user);
}
