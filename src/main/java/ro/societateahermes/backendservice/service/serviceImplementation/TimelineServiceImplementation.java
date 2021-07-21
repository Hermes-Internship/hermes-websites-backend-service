package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.repository.TimelineRepositoryInterface;
import ro.societateahermes.backendservice.service.TimelineServiceInterface;

import java.util.Comparator;
import java.util.List;

@Service
public class TimelineServiceImplementation implements TimelineServiceInterface {

    private final TimelineRepositoryInterface timelineRepository;
    private final EventRepositoryInterface eventRepository;

    @Autowired
    public TimelineServiceImplementation(TimelineRepositoryInterface timelineRepository, EventRepositoryInterface eventRepository) {
        this.timelineRepository = timelineRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Timeline> getAll() {

        return timelineRepository.findAll();
    }

    @Override
    public Timeline getTimelineOfEvent(Long IdEvent) {
        Timeline timeline = new Timeline();

        for (Timeline timelineSelect : getAll()) {
            if(timelineSelect.getEvent().getIdEvent().equals(IdEvent))
                timeline = timelineSelect;
        }
        return timeline;
    }

    @Override
    public Timeline createActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO) {
        Timeline timeline = getTimelineOfEvent(IdEvent);
        timeline.getListOfActivities().add(eventDTO);

        return timeline;
    }

    @Override
    public Timeline updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO) {
        Timeline timeLine = getTimelineOfEvent(IdEvent);
        ActivityDTO activity = timeLine.getListOfActivities().get(activityDTO.getIdActivity().intValue());

        activity.setActivityName(activityDTO.getActivityName());
        activity.setActivityStartDate(activityDTO.getActivityStartDate());
        activity.setActivityLocation(activityDTO.getActivityLocation());

        return timeLine;
    }

    @Override
    public void deleteActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO) {
        Timeline timeLine = getTimelineOfEvent(IdEvent);
        timeLine.getListOfActivities().remove(eventDTO);
    }

    @Override
    public List<ActivityDTO> orderActivityByDateAndTime(Timeline timeLine){

        timeLine.getListOfActivities().sort(Comparator.comparing(ActivityDTO::getActivityStartDate));
        return timeLine.getListOfActivities();
    }

    @Override
    public ActivityDTO getOneActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO) {
        Timeline timeLine = getTimelineOfEvent(IdEvent);

        return timeLine.getListOfActivities().get(activityDTO.getIdActivity().intValue());
    }
}

