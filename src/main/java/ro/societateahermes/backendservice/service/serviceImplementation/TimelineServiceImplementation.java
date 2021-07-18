package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.EventDTO;
import ro.societateahermes.backendservice.entities.Event;
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
    public void save(Timeline timeLine) {
        timelineRepository.save(timeLine);
    }

    @Override
    public List<Timeline> getAll() {

        return timelineRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        for (Timeline timeLine : getAll())
            if (timeLine.getIdTimeline().equals(id))
                timelineRepository.delete(timeLine);
    }

    @Override
    public Timeline createEvenFromTimeline(Long IdTimeLine, EventDTO eventDTO) {
        Timeline timeLine = timelineRepository.getOne(IdTimeLine);
        timeLine.getListOfEvents().add(eventDTO);

        return timeLine;
    }

    @Override
    public void deleteEvenFromTimeline(Long IdTimeLine, Long IdEvent) {
        Timeline timeLine = timelineRepository.getOne(IdTimeLine);
        timeLine.getListOfEvents().remove(IdEvent);
    }

    @Override
    public List<EventDTO> orderByDateAndTime(Timeline timeLine){

        timeLine.getListOfEvents().sort(new Comparator<EventDTO>() {
            @Override
            public int compare(EventDTO o1, EventDTO o2) {
                return o1.getEventStartDate().compareTo(o2.getEventStartDate());
            }
        });
        return timeLine.getListOfEvents();
    }
}

