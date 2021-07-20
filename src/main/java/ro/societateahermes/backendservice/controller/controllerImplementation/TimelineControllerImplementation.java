package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.TimelineControllerInterface;
import ro.societateahermes.backendservice.entities.dto.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.service.serviceImplementation.TimelineServiceImplementation;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/timeline")
public class TimelineControllerImplementation implements TimelineControllerInterface {

    private final TimelineServiceImplementation timeLineService;

    @Autowired
    public TimelineControllerImplementation(TimelineServiceImplementation timeLineService) {
        this.timeLineService = timeLineService;
    }


    @PostMapping()
    @Override
    public Timeline createEvenFromTimeline(@Valid @RequestBody Long IdTimeline, EventDTO eventDTO) {
         return timeLineService.createEvenFromTimeline(IdTimeline, eventDTO);
    }

    @GetMapping
    @Override
    public List<EventDTO> getAllEvenFromTimeline(Timeline timeline) {
        return timeLineService.orderByDateAndTime(timeline);
    }

    @DeleteMapping("/{IdTimeline}")
    @Override
    public void deleteEvenFromTimeline(@Valid @PathVariable("IdTimeline")  Long IdTimeline, @Valid @RequestBody EventDTO IdEvent) {
        timeLineService.deleteEvenFromTimeline(IdTimeline, IdEvent);
    }
}


