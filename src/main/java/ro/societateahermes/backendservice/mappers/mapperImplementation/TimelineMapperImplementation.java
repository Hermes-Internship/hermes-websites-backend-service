package ro.societateahermes.backendservice.mappers.mapperImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;
import ro.societateahermes.backendservice.mappers.ActivityMapperInterface;
import ro.societateahermes.backendservice.mappers.TimelineMapperInterface;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimelineMapperImplementation implements TimelineMapperInterface {

    private final ActivityMapperInterface activityMapper;

    @Autowired
    public TimelineMapperImplementation(ActivityMapperInterface activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public TimelineDTO timelineToTimelineDTO(Timeline timeline) {
        if(timeline == null)
            return null;

        TimelineDTO timelineDTO = new TimelineDTO();

        timelineDTO.setIdTimeline(timeline.getIdTimeline());
        timelineDTO.setIdEvent(timeline.getIdEvent());
        timelineDTO.setListOfActivities(activityMapper.activitiesToActivityDTOS(timeline.getListOfActivities()));

        return timelineDTO;
    }

    @Override
    public List<TimelineDTO> timelinesToTimelineDTOS(List<Timeline> timelines) {

        if (timelines == null )
            return null;

        List<TimelineDTO> timelineDTO = new ArrayList<TimelineDTO>(timelines.size());
        for (Timeline timeline : timelines ) {
            timelineDTO.add(timelineToTimelineDTO(timeline));
        }

        return timelineDTO;
    }
}
