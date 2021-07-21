package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;
import ro.societateahermes.backendservice.mappers.EventMapperInterface;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class EventServiceImplementation implements EventServiceInterface {

    private final EventRepositoryInterface eventRepository;
    private final EventMapperInterface eventMapper;

    @Autowired
    public EventServiceImplementation(EventRepositoryInterface eventRepository, EventMapperInterface eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }


    @Override
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

    @Override
    public List<EventDTO> eventIsOngoing(Event event) {
        List<EventDTO> events = new ArrayList<>();

        LocalDate startDate = LocalDate.from(event.getEventStartDate());
        LocalTime startTime = LocalTime.from(event.getEventStartDate());

        LocalDate endDate = LocalDate.from(event.getEventEndDate());
        LocalTime endTime = LocalTime.from(event.getEventEndDate());

        if (startDate.equals(LocalDate.now()) || LocalDate.now().isBefore(endDate)) {
            if (startTime.equals(LocalTime.now()) || LocalTime.now().isBefore(endTime))
               events = eventMapper.eventsToEventDTOS(getAll());
        }

        return events;
    }
}
