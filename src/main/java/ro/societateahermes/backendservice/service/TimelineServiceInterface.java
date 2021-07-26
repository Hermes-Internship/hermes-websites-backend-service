package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;

import java.util.List;

public interface TimelineServiceInterface {

    List<TimelineDTO> getAllActivityFromTimeline();

    TimelineDTO getTimelineOfEvent(Long IdEvent);

    TimelineDTO createActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO);

    TimelineDTO updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    void deleteActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO);

    List<ActivityDTO> orderActivityByDateAndTime(Long IdEvent);

    ActivityDTO getOneActivityFromTimeline(Long IdEvent, Long IdActivity);

}
