package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface UserServiceInterface {

    void save(User user);

    User saveUserFromDTO(MySubmissionDTO user);

    List<User> getAllUsers();
}
