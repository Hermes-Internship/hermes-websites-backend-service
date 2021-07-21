package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.Timeline;

import java.util.List;

public interface TimelineServiceInterface {

    List<Timeline> getAll();

    Timeline getTimelineOfEvent(Long IdEvent);

    Timeline createActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO);

    Timeline updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    void deleteActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO);

    List<ActivityDTO> orderActivityByDateAndTime(Timeline timeLine);

    ActivityDTO getOneActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);
}
