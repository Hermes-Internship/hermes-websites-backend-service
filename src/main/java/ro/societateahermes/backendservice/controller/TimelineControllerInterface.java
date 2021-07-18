package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.DTO.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;

import java.util.List;

public interface TimelineControllerInterface {

    Timeline createEvenFromTimeline(Long IdTimeline, EventDTO eventDTO);

    List<Timeline> getAll();

    void deleteEvenFromTimeline(Long IdTimeline, Long IdEvent);
}
