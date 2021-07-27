package ro.societateahermes.backendservice.controller;

import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;

import java.util.List;

public interface TimelineControllerInterface {

    void createActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    void updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    void deleteActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO);

    ActivityDTO getOneActivityFromTimeline(Long IdEvent, Long IdActivity);

    List<TimelineDTO> getAllActivityFromTimeline();
    List<ActivityDTO> getAllActivityFromTimelineOrderByDateAndTime(Long IdEvent);
}
