package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.UserControllerInterface;
import ro.societateahermes.backendservice.entities.dto.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.dto.UserDTO;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.service.EventServiceInterface;
import ro.societateahermes.backendservice.service.ParticipationServiceInterface;
import ro.societateahermes.backendservice.service.SubmissionServiceInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerInterface {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private SubmissionServiceInterface submissionService;

    @Autowired
    private ParticipationServiceInterface participationService;

    @Autowired
    private EventServiceInterface eventService;


    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }


    @GetMapping("/{eventId}")
    public List<UserDTO> getAllEventParticipants(@PathVariable("eventId") long eventId) {
        return participationService.getAllUsersFromEvent(eventId);
    }


    @PostMapping
    public void submit(@RequestBody @Valid MySubmissionDTO submission) {
        submissionService.savefromDTO(submission);
        User user = userService.saveUserFromDTO(submission);
        Participation participation = participationService.savefromDTO(user, submission);
        userService.addParticipation(user, participation);
        eventService.addParticipation(submission.getEventId(), participation);


    }

}
