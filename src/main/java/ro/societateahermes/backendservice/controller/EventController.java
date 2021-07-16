package ro.societateahermes.backendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.societateahermes.backendservice.service.EventServiceInterface;
import ro.societateahermes.backendservice.service.dto.NotificationSwitchDTO;

@RestController
public class EventController {

    @Autowired
    private final EventServiceInterface eventServiceInterface;

    public EventController(EventServiceInterface eventServiceInterface) {
        this.eventServiceInterface = eventServiceInterface;
    }

    @GetMapping("/event-status/{eventName}")
    public NotificationSwitchDTO getEventStatus(@PathVariable("eventName") String eventName) {
        return eventServiceInterface.getEventStatusByEventName(eventName);
    }

}
