package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.DTO.EventDTO;

import java.util.List;

//@Mapper(componentModel = "spring")
public interface EventServiceInterface {

    void save(Event event);

    List<Event> getAll();

    EventDTO eventToEventDTO(Event event);

    Event eventDTOToEvent(EventDTO eventDTO);

    List<EventDTO> eventsToEventDTOS(List<Event> events);

    List<EventDTO> eventIsOngoing(Event event);
}
