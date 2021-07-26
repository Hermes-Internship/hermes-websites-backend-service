package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;

import java.util.List;

public interface TimelineControllerInterface {

    TimelineDTO createActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    TimelineDTO updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    void deleteActivityFromTimeline(Long IdEvent, ActivityDTO IdActivity);

    ActivityDTO getOneActivityFromTimeline(Long IdEvent, Long IdActivity);

    List<TimelineDTO> getAllActivityFromTimeline();

    List<ActivityDTO> getAllActivityFromTimelineOrderByDateAndTime(Long IdEvent);

//    TimelineDTO getOneTimeline(Long IdEvent);
}
