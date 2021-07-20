package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class EventServiceImplementation implements EventServiceInterface {

    private final EventRepositoryInterface eventRepository;

    public EventServiceImplementation(EventRepositoryInterface eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public EventDTO eventToEventDTO(Event event) {
        if(event == null)
            return null;

        EventDTO eventDTO = new EventDTO();

        eventDTO.setIdEvent(event.getIdEvent());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventStartDate(event.getEventStartDate());
        eventDTO.setLocation(event.getLocation());

        return eventDTO;
    }

    @Override
    public Event eventDTOToEvent(EventDTO eventDTO) {
        if(eventDTO == null)
            return null;

        Event event = new Event();

        event.setIdEvent(eventDTO.getIdEvent());
        event.setEventName(eventDTO.getEventName());
        event.setEventStartDate(eventDTO.getEventStartDate());
        event.setLocation(eventDTO.getLocation());

        return event;
    }

    @Override
    public List<EventDTO> eventsToEventDTOS(List<Event> events) {
        if (events == null )
            return null;

        List<EventDTO> eventDTOS = new ArrayList<EventDTO>(events.size());
        for (Event event : events ) {
            eventDTOS.add(eventToEventDTO(event));
        }

        return eventDTOS;
    }

    @Override
    public List<EventDTO> eventIsOngoing(Event event) {
        List<EventDTO> events = new ArrayList<>();

        LocalDate startDate = LocalDate.from(event.getEventStartDate());
        LocalTime startTime = LocalTime.from(event.getEventStartDate());

        LocalDate endDate = LocalDate.from(event.getEventEndTime());
        LocalTime endTime = LocalTime.from(event.getEventEndTime());

        if (startDate.equals(LocalDate.now()) || LocalDate.now().isBefore(endDate)) {
            if (startTime.equals(LocalTime.now()) || LocalTime.now().isBefore(endTime))
                events = eventsToEventDTOS(getAll());
        }

        return events;
    }

}