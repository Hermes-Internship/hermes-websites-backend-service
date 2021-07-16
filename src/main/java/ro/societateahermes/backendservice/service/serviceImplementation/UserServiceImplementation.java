package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.repository.UserRepositoryInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;

import javax.transaction.Transactional;
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id){
        for(User user : userRepository.findAll())
        {
            if (user.getID() == id ){
                userRepository.delete(user);
                return;
            }
        }
        /// throw exception user not found ?
    }


    @Override
    @Transactional
    public void update(UserDTO user) {
        if (user != null) {
            User updatedUser = userRepository.getOne(user.getID());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setField(user.getField());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setUsername(user.getUsername());
            updatedUser.setLanguage(user.getLanguage());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setUniversity(user.getUniversity());
            updatedUser.setYearOfStudy(user.getYearOfStudy());
        }else{
            ///throw error
        }
    }
}
