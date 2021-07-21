package ro.societateahermes.backendservice.mappers;

import org.mapstruct.Mapper;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ActivityMapperInterface {

    ActivityDTO activityToActivityDTO(Activity activity);

    List<ActivityDTO> activitiesToActivityDTOS(List<Activity> activities);
}
