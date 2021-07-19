package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.repository.UserRepositoryInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;

import java.util.List;

@Service
public class UserServiceImplementation implements UserServiceInterface {
    private final UserRepositoryInterface userRepository;

    UserServiceImplementation(UserRepositoryInterface userRepo) {
        userRepository = userRepo;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User saveUserFromDTO(MySubmissionDTO submissionDTO) {

        User user = new User();

        user.setFirstName(submissionDTO.getFirstName());
        user.setLastName(submissionDTO.getLastName());
        user.setEmail(submissionDTO.getEmail());
        user.setUsername(submissionDTO.getUsername());
        user.setPassword(submissionDTO.getPassword());
        user.setUniversity(submissionDTO.getUniversity());

        return userRepository.save(user);
    }

    @Override
    public void addParticipation(User user, Participation participation) {
        List<Participation> participationList = user.getListOfParticipation();
        participationList.add(participation);
        user.setListOfParticipation(participationList);

    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
