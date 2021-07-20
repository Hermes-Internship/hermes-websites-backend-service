package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;

import java.util.List;

public interface EventServiceInterface {

    List<Event> getAll();

    NotificationSwitchDTO getEventStatusByEventName(String eventName);

    List<EventDTO> eventIsOngoing(Event event);
}
