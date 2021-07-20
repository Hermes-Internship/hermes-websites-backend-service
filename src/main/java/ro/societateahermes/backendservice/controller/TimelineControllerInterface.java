package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;

import java.util.List;

public interface TimelineControllerInterface {

    Timeline createEvenFromTimeline(Long IdTimeline, EventDTO eventDTO);

    List<EventDTO> getAllEvenFromTimeline(Timeline timeline);

    void deleteEvenFromTimeline(Long IdTimeline, EventDTO IdEvent);
}
