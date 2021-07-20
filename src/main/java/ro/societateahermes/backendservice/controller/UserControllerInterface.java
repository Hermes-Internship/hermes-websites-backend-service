package ro.societateahermes.backendservice.controller;


import ro.societateahermes.backendservice.entities.dto.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.dto.UserDTO;

import java.util.List;

public interface UserControllerInterface {

    List<UserDTO> getAll();

    void submit(MySubmissionDTO submission);

    List<UserDTO> getAllEventParticipants(long eventId);


}
