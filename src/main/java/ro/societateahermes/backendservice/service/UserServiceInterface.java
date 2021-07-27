package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface UserServiceInterface {
    void save(UserDTO user);

    List<UserDTO> getAllUsers();

    void delete(Long id);

    void update(UserDTO user);
}
