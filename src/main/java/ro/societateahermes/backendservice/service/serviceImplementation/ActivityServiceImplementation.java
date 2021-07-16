package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.DTO.ActivityDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.repository.ActivityRepositoryInterface;
import ro.societateahermes.backendservice.service.ActivityServiceInterface;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImplementation implements ActivityServiceInterface {
    private final ActivityRepositoryInterface activityRepository;

    public ActivityServiceImplementation(ActivityRepositoryInterface activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void save(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        for(Activity activity  : activityRepository.findAll())
        {
            if (activity.getIdActivity() == id ){
                activityRepository.delete(activity);
                return;
            }
        }
    }

    @Override
    public void update(ActivityDTO activity) {
        if (activity != null){
            Activity updatedActivity = activityRepository.getOne(activity.getIdActivity());
            updatedActivity.setActivityLink(activity.getActivityLink());
            updatedActivity.setActivityName(activity.getActivityName());
            updatedActivity.setActivityDescription(activity.getActivityDescription());
            updatedActivity.setActivityEndDate(activity.getActivityEndDate());
            updatedActivity.setActivityStartDate(activity.getActivityStartDate());
            updatedActivity.setActivityEstimatedTime(activity.getActivityEstimatedTime());
            updatedActivity.setMaximumNumberOfParticipants(activity.getMaximumNumberOfParticipants());
            updatedActivity.setEvent(activity.getEvent());
        }
    }
}
