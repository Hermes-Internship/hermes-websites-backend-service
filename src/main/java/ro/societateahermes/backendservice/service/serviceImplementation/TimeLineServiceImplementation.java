package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.TimeLine;
import ro.societateahermes.backendservice.repository.TimeLineRepositoryInterface;
import ro.societateahermes.backendservice.service.TimeLineServiceInterface;

import java.util.Comparator;
import java.util.List;

@Service
public class TimeLineServiceImplementation implements TimeLineServiceInterface {

    private final TimeLineRepositoryInterface timeLineRepository;


    public TimeLineServiceImplementation(TimeLineRepositoryInterface timeLineRepository) {
        this.timeLineRepository = timeLineRepository;
    }

    @Override
    public void save(TimeLine timeLine) {
        timeLineRepository.save(timeLine);
    }

    @Override
    public List<TimeLine> getAll() {

        return timeLineRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        for (TimeLine timeLine : getAll())
            if (timeLine.getIdTimeLine().equals(id))
                timeLineRepository.delete(timeLine);
    }

    public void createEvenFromTimeline(Long IdTimeLine, Event event) {
        TimeLine timeLine = timeLineRepository.getOne(IdTimeLine);
        timeLine.getListOfEvents().add(event);
    }

    public void deleteEvenFromTimeline(Long IdTimeLine, Long IdEvent) {
        TimeLine timeLine = timeLineRepository.getOne(IdTimeLine);
        timeLine.getListOfEvents().remove(IdEvent);
    }

    public List<Event> orderByDateAndTime(TimeLine timeLine){

        timeLine.getListOfEvents().sort(new SortByDateAndTime());
        return timeLine.getListOfEvents();
    }
}

class SortByDateAndTime implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        return o1.getEventStartDate().compareTo(o2.getEventStartDate());
    }
}
