package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.Timeline;

import java.util.List;

public interface TimelineControllerInterface {

    Timeline createActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    Timeline updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    void deleteActivityFromTimeline(Long IdEvent, ActivityDTO IdActivity);

    ActivityDTO getOneActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    List<ActivityDTO> getAllActivityFromTimeline(Timeline timeline);
}
