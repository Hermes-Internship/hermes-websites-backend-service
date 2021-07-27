package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.repository.UserRepositoryInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;
import ro.societateahermes.backendservice.utils.mapper.UserMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImplementation implements UserServiceInterface {
    private final UserRepositoryInterface userRepository;

    UserServiceImplementation(UserRepositoryInterface userRepo) {
        userRepository = userRepo;
    }

    @Override
    public void save(UserDTO user) {

        userRepository.save(UserMapper.userDTOtoUser(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return UserMapper.usersToUsersDTO(userRepository.findAll());
    }

    @Override
    @Transactional
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

            userRepository.save(UserMapper.userDTOtoUser(user));
        }else{
            ///throw error
        }
    }
}
