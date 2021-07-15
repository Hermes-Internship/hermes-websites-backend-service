package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.EventDTO;

import java.util.List;

public interface EventServiceInterface {

    void save(Event event);

    List<Event> getAll();

    EventDTO convertToEventDTO(Event event);

    List<EventDTO> getAllEventsDTO();

    List<EventDTO> eventIsOngoing(Event event);
}
