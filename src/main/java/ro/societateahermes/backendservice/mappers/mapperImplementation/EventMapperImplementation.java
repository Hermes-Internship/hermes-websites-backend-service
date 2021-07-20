package ro.societateahermes.backendservice.mappers.mapperImplementation;

import org.springframework.stereotype.Component;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.mappers.EventMapperInterface;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-07-20T13:12:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11"
)

@Component
public class EventMapperImplementation implements EventMapperInterface {
    
    @Override
    public EventDTO eventToEventDTO(Event event) {

        if(event == null)
            return null;

        EventDTO eventDTO = new EventDTO();

        eventDTO.setIdEvent(event.getIdEvent());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventStartDate(event.getEventStartDate());
        eventDTO.setLocation(event.getEventLocation());

        return eventDTO;
    }

    @Override
    public List<EventDTO> eventsToEventDTOS(List<Event> events) {

        if (events == null )
            return null;

        List<EventDTO> eventDTOS = new ArrayList<EventDTO>(events.size());
        for (Event event : events ) {
            eventDTOS.add(eventToEventDTO(event));
        }

        return eventDTOS;
    }
}
