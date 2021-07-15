package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.EventDTO;
import ro.societateahermes.backendservice.entities.TimeLine;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public EventDTO convertToEventDTO(Event event) {
        EventDTO eventDTO = new EventDTO();

        eventDTO.setIdEvent(event.getIdEvent());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventStartDate(event.getEventStartDate());
        eventDTO.setLocation(event.getLocation());

        return eventDTO;
    }

    @Override
    public List<EventDTO> getAllEventsDTO() {
        return ((List<Event>) eventRepository
                .findAll())
                .stream()
                .map(this::convertToEventDTO)
                .collect(Collectors.toList());
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
                events = getAllEventsDTO();
        }

        return events;
    }

}