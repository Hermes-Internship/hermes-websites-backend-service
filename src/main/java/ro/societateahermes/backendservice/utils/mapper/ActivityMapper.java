package ro.societateahermes.backendservice.utils.mapper;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.dto.FullActivityDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityMapper {
    public static Activity activityDTOtoActivity(FullActivityDTO activity){
        Activity activityFromDTO = new Activity();
        activityFromDTO.setIdActivity(activity.getIdActivity());
        activityFromDTO.setActivityLink(activity.getActivityLink());
        activityFromDTO.setActivityName(activity.getActivityName());
        activityFromDTO.setActivityDescription(activity.getActivityDescription());
        activityFromDTO.setActivityEndDate(activity.getActivityEndDate());
        activityFromDTO.setActivityStartDate(activity.getActivityStartDate());
        activityFromDTO.setActivityEstimatedTime(activity.getActivityEstimatedTime());
        activityFromDTO.setMaximumNumberOfParticipants(activity.getMaximumNumberOfParticipants());
        activityFromDTO.setEvent(activity.getEvent());
        return activityFromDTO;
    }
    public static List<FullActivityDTO> activitiesToActivitiesDTO(List<Activity> activities){

         return activities.stream().map(ActivityMapper::activityToActivityDTO).collect(Collectors.toList());
    }

    public static FullActivityDTO activityToActivityDTO(Activity activity){
        FullActivityDTO fullActivityDTO = new FullActivityDTO();
        fullActivityDTO.setIdActivity(activity.getIdActivity());
        fullActivityDTO.setActivityLink(activity.getActivityLink());
        fullActivityDTO.setActivityName(activity.getActivityName());
        fullActivityDTO.setActivityDescription(activity.getActivityDescription());
        fullActivityDTO.setActivityEndDate(activity.getActivityEndDate());
        fullActivityDTO.setActivityStartDate(activity.getActivityStartDate());
        fullActivityDTO.setActivityEstimatedTime(activity.getActivityEstimatedTime());
        fullActivityDTO.setMaximumNumberOfParticipants(activity.getMaximumNumberOfParticipants());
        fullActivityDTO.setEvent(activity.getEvent());
        return fullActivityDTO;
    }
}
