package ro.societateahermes.backendservice.mappers;

import org.mapstruct.Mapper;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.EventDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface EventMapperInterface {

    EventDTO eventToEventDTO(Event event);

    List<EventDTO> eventsToEventDTOS(List<Event> events);
}
