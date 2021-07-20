package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;

import java.util.List;

public interface TimelineServiceInterface {

    void save(Timeline timeLine);

    List<Timeline> getAll();

    void delete(Long idTimeLine);

    Timeline createEvenFromTimeline(Long IdTimeLine, EventDTO eventDTO);

    void deleteEvenFromTimeline(Long IdTimeLine, Long IdEvent);

    List<EventDTO> orderByDateAndTime(Timeline timeLine);
}
