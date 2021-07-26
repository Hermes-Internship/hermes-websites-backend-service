package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;

public interface EventServiceInterface {

    void addParticipation(long eventID, Participation participation);

    NotificationSwitchDTO getEventStatusByEventName(String eventName);
}
