package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.UserControllerInterface;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.service.SubmissionServiceInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerInterface {

    private UserServiceInterface userService;
    private SubmissionServiceInterface submissionService;

    public UserController(UserServiceInterface userService,SubmissionServiceInterface submissionService) {

        this.userService = userService;
        this.submissionService=submissionService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void submit(@RequestBody MySubmissionDTO submission){
        submissionService.savefromDTO(submission);
        userService.saveUserFromDTO(submission);
    }


}
