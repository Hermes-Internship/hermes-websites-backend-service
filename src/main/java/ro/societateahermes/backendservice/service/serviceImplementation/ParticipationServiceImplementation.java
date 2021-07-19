package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.repository.ParticipationRepositoryInterface;
import ro.societateahermes.backendservice.repository.UserRepositoryInterface;
import ro.societateahermes.backendservice.service.ParticipationServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipationServiceImplementation implements ParticipationServiceInterface {

    private final UserRepositoryInterface userRepository;
    private final EventRepositoryInterface eventRepository;
    private final ParticipationRepositoryInterface participationRepository;

    public ParticipationServiceImplementation(UserRepositoryInterface userRepo, EventRepositoryInterface eventRepository, ParticipationRepositoryInterface participationRepository) {

        this.userRepository = userRepo;
        this.eventRepository = eventRepository;
        this.participationRepository = participationRepository;
    }

    @Override
    public Participation savefromDTO(User user, MySubmissionDTO submissionDTO) {

        Event event = eventRepository.getOne(submissionDTO.getEventId());
        Participation participation = new Participation();
        participation.setEvent(event);
        participation.setUser(user);

        return participationRepository.save(participation);


    }

    @Override
    public List<User> getAllUsersFromEvent(Long eventId) {
        List<User> users = new ArrayList<>();
        for (Participation participation : participationRepository.findAll()) {
            if (participation.getEvent().getIdEvent() == eventId)
                users.add(participation.getUser());

        }
        return users;

    }
}
