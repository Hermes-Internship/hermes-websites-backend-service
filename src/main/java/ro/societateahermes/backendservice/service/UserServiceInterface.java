package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface UserServiceInterface {
    void save(User user);

    List<User> getAllUsers();

    void delete(Long id);

    void update(UserDTO user);
}
