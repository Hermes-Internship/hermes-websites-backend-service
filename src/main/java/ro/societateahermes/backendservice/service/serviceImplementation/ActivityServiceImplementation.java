package ro.societateahermes.backendservice.service.serviceImplementation;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.mappers.ActivityMapperInterface;
import ro.societateahermes.backendservice.repository.ActivityRepositoryInterface;
import ro.societateahermes.backendservice.service.ActivityServiceInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityServiceImplementation implements ActivityServiceInterface {

    private final ActivityRepositoryInterface activityRepository;
    private final ActivityMapperInterface activityMapper;

    public ActivityServiceImplementation(ActivityRepositoryInterface activityRepository, ActivityMapperInterface activityMapper) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
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
                activities = activityMapper.activitiesToActivityDTOS(activityRepository.findAll());
        }

        return activities;
    }
}
