package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.dto.FullActivityDTO;
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
    public void save(FullActivityDTO activity) {
        activityRepository.save(ActivityMapper.activityDTOtoActivity(activity));
    }

    @Override
    public List<FullActivityDTO> getAllActivities() {
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
    public void update(FullActivityDTO activity) {
        if (activity != null){
            Activity updatedActivity = ActivityMapper.activityDTOtoActivity(activity);
            activityRepository.save(updatedActivity);
        }
    }
}
