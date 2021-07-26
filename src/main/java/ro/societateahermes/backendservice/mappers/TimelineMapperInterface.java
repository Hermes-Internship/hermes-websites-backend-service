package ro.societateahermes.backendservice.mappers;

import org.mapstruct.Mapper;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TimelineMapperInterface {

    TimelineDTO timelineToTimelineDTO(Timeline timeline);

    List<TimelineDTO> timelinesToTimelineDTOS(List<Timeline> timelines);
}
