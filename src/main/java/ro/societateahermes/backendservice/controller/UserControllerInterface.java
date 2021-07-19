package ro.societateahermes.backendservice.controller;


import org.springframework.web.bind.annotation.PathVariable;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;

import java.util.List;

public interface UserControllerInterface {

    List<UserDTO> getAll();

    void submit(MySubmissionDTO submission);

    List<UserDTO> getAllEventParticipants(long eventId);


}
