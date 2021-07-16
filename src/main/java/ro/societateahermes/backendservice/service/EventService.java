package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.service.dto.NotificationSwitchDTO;

public interface EventService {

    NotificationSwitchDTO getEventStatusByEventName(String eventName);

    void doSmth();
}
