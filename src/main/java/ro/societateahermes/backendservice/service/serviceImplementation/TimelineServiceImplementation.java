package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;
import ro.societateahermes.backendservice.mappers.TimelineMapperInterface;
import ro.societateahermes.backendservice.repository.TimelineRepositoryInterface;
import ro.societateahermes.backendservice.service.TimelineServiceInterface;

import java.util.Comparator;
import java.util.List;

@Service
public class TimelineServiceImplementation implements TimelineServiceInterface {

    private final TimelineRepositoryInterface timelineRepository;
    private final TimelineMapperInterface timelineMapper;

    @Autowired
    public TimelineServiceImplementation(TimelineRepositoryInterface timelineRepository, TimelineMapperInterface timelineMapper) {
        this.timelineRepository = timelineRepository;
        this.timelineMapper = timelineMapper;
    }

    @Override
    public List<TimelineDTO> getAllActivityFromTimeline() {
        return timelineMapper.timelinesToTimelineDTOS(timelineRepository.findAll());
    }

    @Override
    public TimelineDTO getTimelineOfEvent(Long IdEvent) {
        TimelineDTO timelineDTO = new TimelineDTO();

        for (TimelineDTO timelineSelect : getAllActivityFromTimeline()) {
            if(timelineSelect.getIdEvent().equals(IdEvent))
                timelineDTO = timelineSelect;
        }
        return timelineDTO;
    }

    @Override
    public TimelineDTO createActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO) {
        TimelineDTO timelineDTO = getTimelineOfEvent(IdEvent);
        timelineDTO.getListOfActivities().add(activityDTO);

        return timelineDTO;
    }

    @Override
    public TimelineDTO updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO) {
        TimelineDTO timelineDTO = getTimelineOfEvent(IdEvent);
        ActivityDTO activity = timelineDTO.getListOfActivities().get(activityDTO.getIdActivity().intValue());

        activity.setActivityName(activityDTO.getActivityName());
        activity.setActivityStartDate(activityDTO.getActivityStartDate());
        activity.setActivityLocation(activityDTO.getActivityLocation());

        return timelineDTO;
    }

    @Override
    public void deleteActivityFromTimeline(Long IdEvent, ActivityDTO eventDTO) {
        TimelineDTO timelineDTO = getTimelineOfEvent(IdEvent);
        timelineDTO.getListOfActivities().remove(eventDTO);
    }

    @Override
    public List<ActivityDTO> orderActivityByDateAndTime(Long IdEvent){
        TimelineDTO timelineDTO = getTimelineOfEvent(IdEvent);
        timelineDTO.getListOfActivities().sort(Comparator.comparing(ActivityDTO::getActivityStartDate));

        return timelineDTO.getListOfActivities();
    }

    @Override
    public ActivityDTO getOneActivityFromTimeline(Long IdEvent, Long IdActivity) {
        TimelineDTO timeLine = getTimelineOfEvent(IdEvent);

        return timeLine.getListOfActivities().get(IdActivity.intValue());
    }
}

