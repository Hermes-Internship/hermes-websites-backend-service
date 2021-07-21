package ro.societateahermes.backendservice.mappers.mapperImplementation;

import org.springframework.stereotype.Component;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.mappers.ActivityMapperInterface;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-07-20T13:12:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11"
)

@Component
public class ActivityMapperImplementation implements ActivityMapperInterface {
    
    @Override
    public ActivityDTO activityToActivityDTO(Activity activity) {

        if(activity == null)
            return null;

        ActivityDTO activityDTO = new ActivityDTO();

        activityDTO.setIdActivity(activity.getIdActivity());
        activityDTO.setActivityName(activity.getActivityName());
        activityDTO.setActivityStartDate(activity.getActivityStartDate());
        activityDTO.setActivityLocation(activity.getActivityLocation());

        return activityDTO;
    }

    @Override
    public List<ActivityDTO> activitiesToActivityDTOS(List<Activity> activities) {

        if (activities == null )
            return null;

        List<ActivityDTO> eventDTOS = new ArrayList<ActivityDTO>(activities.size());
        for (Activity activity : activities ) {
            eventDTOS.add(activityToActivityDTO(activity));
        }

        return eventDTOS;
    }
}
