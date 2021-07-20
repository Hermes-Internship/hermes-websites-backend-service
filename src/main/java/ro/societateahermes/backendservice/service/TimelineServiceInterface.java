package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;

import java.util.List;

public interface TimelineServiceInterface {

    List<Timeline> getAll();

    Timeline createEvenFromTimeline(Long IdTimeLine, EventDTO eventDTO);

    void deleteEvenFromTimeline(Long IdTimeLine, EventDTO eventDTO);

    List<EventDTO> orderByDateAndTime(Timeline timeLine);
}
