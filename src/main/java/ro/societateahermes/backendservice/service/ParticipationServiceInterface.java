package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface ParticipationServiceInterface {

    void savefromDTO(User user, MySubmissionDTO submissionDTO);

    List<User> getAllUsersFromEvent(Long eventId);
}
