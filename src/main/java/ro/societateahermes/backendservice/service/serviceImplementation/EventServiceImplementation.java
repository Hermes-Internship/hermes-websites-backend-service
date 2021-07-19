package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;

import java.util.List;


@Service
public class EventServiceImplementation implements EventServiceInterface {

    private final EventRepositoryInterface eventRepository;

    public EventServiceImplementation(EventRepositoryInterface eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public void addParticipation(long eventID, Participation participation) {
        Event event = eventRepository.getOne(eventID);
        List<Participation> participationList = event.getListOfParticipation();
        participationList.add(participation);
        event.setListOfParticipation(participationList);

    }
}
