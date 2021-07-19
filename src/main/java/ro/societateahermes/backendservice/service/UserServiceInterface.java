package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface UserServiceInterface {

    User saveUserFromDTO(MySubmissionDTO user);

    void addParticipation(User user, Participation participation);

    List<UserDTO> getAllUsers();
}
