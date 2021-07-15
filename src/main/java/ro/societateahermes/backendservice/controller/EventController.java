package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.societateahermes.backendservice.service.dto.NotificationSwitchDTO;
import ro.societateahermes.backendservice.service.serviceImplementation.EventServiceImplementation;

@RestController
public class EventController {

    private final EventServiceImplementation eventServiceImplementation;

    public EventController(EventServiceImplementation eventServiceImplementation) {
        this.eventServiceImplementation = eventServiceImplementation;
    }

    @GetMapping("/event-status/{eventName}")
    public NotificationSwitchDTO getEventStatus(@PathVariable("eventName") String eventName) {
        return eventServiceImplementation.getEventStatusByEventName(eventName);
    }

}
