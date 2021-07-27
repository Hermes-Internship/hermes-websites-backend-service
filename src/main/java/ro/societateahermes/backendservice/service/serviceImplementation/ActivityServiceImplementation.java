package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.DTO.ActivityDTO;
import ro.societateahermes.backendservice.utils.mapper.ActivityMapper;
import ro.societateahermes.backendservice.repository.ActivityRepositoryInterface;
import ro.societateahermes.backendservice.service.ActivityServiceInterface;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActivityServiceImplementation implements ActivityServiceInterface {
    private final ActivityRepositoryInterface activityRepository;

    public ActivityServiceImplementation(ActivityRepositoryInterface activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void save(ActivityDTO activity) {
        activityRepository.save(ActivityMapper.activityDTOtoActivity(activity));
    }

    @Override
    public List<ActivityDTO> getAllActivities() {
         return ActivityMapper.activitiesToActivitiesDTO(activityRepository.findAll());
    }

    @Override
    @Transactional
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
    @Transactional
    public void update(ActivityDTO activity) {
        if (activity != null){
            Activity updatedActivity = ActivityMapper.activityDTOtoActivity(activity);
            activityRepository.save(updatedActivity);
        }
    }
}
