package ro.societateahermes.backendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.societateahermes.backendservice.entities.dto.NotificationSwitchDTO;
import ro.societateahermes.backendservice.service.EventServiceInterface;


@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private final EventServiceInterface eventServiceInterface;

    public EventController(EventServiceInterface eventServiceInterface) {
        this.eventServiceInterface = eventServiceInterface;
    }

    @GetMapping("/status/{eventName}")
    public NotificationSwitchDTO getEventStatus(@PathVariable("eventName") String eventName) {
        return eventServiceInterface.getEventStatusByEventName(eventName);
    }
}
