package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;

import java.util.List;

public interface EventServiceInterface {
    List<Event> getAll();

    void addParticipation(long eventID, Participation participation);

    NotificationSwitchDTO getEventStatusByEventName(String eventName);

    boolean isDaysBeforeEvent(Event event, Integer daysBefore);

    boolean isDuringEvent(Event event);
}
