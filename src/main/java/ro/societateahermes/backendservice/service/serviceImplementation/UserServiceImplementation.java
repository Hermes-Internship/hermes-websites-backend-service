package ro.societateahermes.backendservice.service.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.entities.dto.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.dto.UserDTO;
import ro.societateahermes.backendservice.repository.UserRepositoryInterface;
import ro.societateahermes.backendservice.service.UserServiceInterface;
import ro.societateahermes.backendservice.utils.mapper.SubmissionMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserServiceInterface {

    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public User saveUserFromDTO(MySubmissionDTO submissionDTO) {

        SubmissionMapper submissionMapper=new SubmissionMapper();
        User user = submissionMapper.convertToUser(submissionDTO);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void addParticipation(User user, Participation participation) {
        List<Participation> participationList = user.getListOfParticipation();
        participationList.add(participation);
        user.setListOfParticipation(participationList);
        userRepository.save(user);
    }


    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

}
