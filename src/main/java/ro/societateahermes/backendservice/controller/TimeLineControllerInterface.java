package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.EventDTO;
import ro.societateahermes.backendservice.entities.TimeLine;

import java.util.List;

public interface TimeLineControllerInterface {

    void save(TimeLine timeLine);

    List<TimeLine> getAll();

    void delete(Long IdTimeLine);
}
