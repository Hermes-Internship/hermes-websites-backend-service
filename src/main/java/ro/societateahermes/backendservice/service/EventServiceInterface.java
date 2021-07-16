package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.service.dto.NotificationSwitchDTO;

public interface EventServiceInterface {

    NotificationSwitchDTO getEventStatusByEventName(String eventName);

}
