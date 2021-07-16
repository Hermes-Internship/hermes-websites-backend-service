package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.UserControllerInterface;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.service.ParticipationServiceInterface;
import ro.societateahermes.backendservice.service.SubmissionServiceInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerInterface {

    private UserServiceInterface userService;
    private SubmissionServiceInterface submissionService;
    private ParticipationServiceInterface participationService;

    public UserController(UserServiceInterface userService, SubmissionServiceInterface submissionService, ParticipationServiceInterface participationService) {
        this.userService = userService;
        this.submissionService = submissionService;
        this.participationService = participationService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }


    @GetMapping("/{eventId}")
    public List<User> getAllEventParticipants(@PathVariable("eventId") long eventId) {
        return participationService.getAllUsersFromEvent(eventId);
    }


    @PostMapping
    public void submit(@RequestBody @Valid MySubmissionDTO submission) {
        submissionService.savefromDTO(submission);
        User user = userService.saveUserFromDTO(submission);
        participationService.savefromDTO(user, submission);

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}
