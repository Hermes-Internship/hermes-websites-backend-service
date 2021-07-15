package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.User;

import java.util.List;

public interface UserControllerInterface {

    List<User> getAll();

    void submit(MySubmissionDTO submission);


}
