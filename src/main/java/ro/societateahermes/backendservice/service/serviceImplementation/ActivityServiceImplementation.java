package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;
import ro.societateahermes.backendservice.utils.mapper.ActivityMapperInterface;
import ro.societateahermes.backendservice.repository.ActivityRepositoryInterface;
import ro.societateahermes.backendservice.service.ActivityServiceInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImplementation implements ActivityServiceInterface {

    private final ActivityRepositoryInterface activityRepository;
    private final ActivityMapperInterface activityMapper;

    @Autowired
    public ActivityServiceImplementation(ActivityRepositoryInterface activityRepository, ActivityMapperInterface activityMapper) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
    }

    @Override
    public void save(ActivityDTO activityDTO) {
        activityRepository.save(activityMapper.convertToActivity(activityDTO));
    }

    @Override
    public void delete(ActivityDTO activityDTO) {
        activityRepository.delete(activityMapper.convertToActivity(activityDTO));
    }

    @Override
    public List<ActivityDTO> eventIsOngoing(Activity activity) {
        List<ActivityDTO> activities = new ArrayList<>();

        LocalDate startDate = LocalDate.from(activity.getActivityStartDate());
        LocalTime startTime = LocalTime.from(activity.getActivityStartDate());

        LocalDate endDate = LocalDate.from(activity.getActivityEndDate());
        LocalTime endTime = LocalTime.from(activity.getActivityEndDate());

        if (startDate.equals(LocalDate.now()) || LocalDate.now().isBefore(endDate)) {
            if (startTime.equals(LocalTime.now()) || LocalTime.now().isBefore(endTime))
                activities = activityMapper.convertToActivityDTOS(activityRepository.findAll());
        }

        return activities;
    }

    @Override
    public void update(ActivityDTO activityDTO, TimelineDTO timelineDTO) {
        Activity activity = activityMapper.convertToActivity(activityDTO);

        Event event = new Event();
        event.setIdEvent(timelineDTO.getIdEvent());

        Timeline timeline = new Timeline();
        timeline.setIdTimeline(timelineDTO.getIdTimeline());

        activity.setEvent(event);
        activity.setTimeline(timeline);

        activityRepository.save(activity);
    }
}
