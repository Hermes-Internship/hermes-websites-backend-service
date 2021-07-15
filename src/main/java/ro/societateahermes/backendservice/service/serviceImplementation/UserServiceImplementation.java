package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.repository.UserRepositoryInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;

import java.util.List;

@Service
public class UserServiceImplementation implements UserServiceInterface {
    private final UserRepositoryInterface userRepository;
    /* private final ActivityRepositoryInterface activityRepository;
    private final EventRepositoryInterface eventRepository;*/

    UserServiceImplementation(UserRepositoryInterface userRepo) {
        userRepository = userRepo;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveUserFromDTO(MySubmissionDTO submissionDTO) {

        User user =new User(submissionDTO.getFirstName(),submissionDTO.getLastName(),submissionDTO.getEmail(),submissionDTO.getUsername(),submissionDTO.getPassword(),submissionDTO.getUniversity());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
