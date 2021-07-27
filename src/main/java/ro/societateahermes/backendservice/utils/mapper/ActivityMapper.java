package ro.societateahermes.backendservice.utils.mapper;

import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.DTO.ActivityDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityMapper {
    public static Activity activityDTOtoActivity(ActivityDTO activity){
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
    public static List<ActivityDTO> activitiesToActivitiesDTO(List<Activity> activities){

         return activities.stream().map(ActivityMapper::activityToActivityDTO).collect(Collectors.toList());
    }

    public static ActivityDTO activityToActivityDTO(Activity activity){
        ActivityDTO  activityDTO = new ActivityDTO();
        activityDTO.setIdActivity(activity.getIdActivity());
        activityDTO.setActivityLink(activity.getActivityLink());
        activityDTO.setActivityName(activity.getActivityName());
        activityDTO.setActivityDescription(activity.getActivityDescription());
        activityDTO.setActivityEndDate(activity.getActivityEndDate());
        activityDTO.setActivityStartDate(activity.getActivityStartDate());
        activityDTO.setActivityEstimatedTime(activity.getActivityEstimatedTime());
        activityDTO.setMaximumNumberOfParticipants(activity.getMaximumNumberOfParticipants());
        activityDTO.setEvent(activity.getEvent());
        return activityDTO;
    }
}
