package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.dto.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    void save(UserDTO user);

    List<UserDTO> getAllUsers();

    void delete(Long id);

    void update(UserDTO user);
}
