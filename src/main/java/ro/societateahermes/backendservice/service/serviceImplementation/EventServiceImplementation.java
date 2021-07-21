package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImplementation implements EventServiceInterface {

    @Autowired
    private  EventRepositoryInterface eventRepository;



    @Override
    public void addParticipation(long eventID, Participation participation) {
        Event event = eventRepository.getOne(eventID);
        List<Participation> participationList = event.getListOfParticipation();
        participationList.add(participation);
        event.setListOfParticipation(participationList);

    }

    public NotificationSwitchDTO getEventStatusByEventName(String eventName) {
        Optional<Event> eventOptional = eventRepository.findByEventName(eventName);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            if (event.getEventStartDate().isAfter(LocalDateTime.now())) {
                return new NotificationSwitchDTO("Event has not started yet", false);
            }
            if (event.getEventEndDate().isAfter(LocalDateTime.now())) {
                return new NotificationSwitchDTO("Event has started", true);
            }
            return new NotificationSwitchDTO("Event has finished", false);

        }
        return new NotificationSwitchDTO("Event not found", false);
    }
}
