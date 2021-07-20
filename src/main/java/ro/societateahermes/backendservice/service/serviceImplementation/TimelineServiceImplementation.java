package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.repository.TimelineRepositoryInterface;
import ro.societateahermes.backendservice.service.TimelineServiceInterface;

import java.util.Comparator;
import java.util.List;

@Service
public class TimelineServiceImplementation implements TimelineServiceInterface {

    private final TimelineRepositoryInterface timelineRepository;

    public TimelineServiceImplementation(TimelineRepositoryInterface timeLineRepository) {
        this.timelineRepository = timeLineRepository;
    }

    @Override
    public List<Timeline> getAll() {

        return timelineRepository.findAll();
    }

    @Override
    public Timeline createEvenFromTimeline(Long IdTimeLine, EventDTO eventDTO) {
        Timeline timeLine = timelineRepository.getOne(IdTimeLine);
        timeLine.getListOfEvents().add(eventDTO);

        return timeLine;
    }

    @Override
    public void deleteEvenFromTimeline(Long IdTimeLine, EventDTO eventDTO) {
        Timeline timeLine = timelineRepository.getOne(IdTimeLine);
        timeLine.getListOfEvents().remove(eventDTO);
    }

    @Override
    public List<EventDTO> orderByDateAndTime(Timeline timeLine){

        timeLine.getListOfEvents().sort(Comparator.comparing(EventDTO::getEventStartDate));
        return timeLine.getListOfEvents();
    }
}

