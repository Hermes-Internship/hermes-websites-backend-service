package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.TimelineControllerInterface;
import ro.societateahermes.backendservice.entities.DTO.EventDTO;
import ro.societateahermes.backendservice.entities.Timeline;
import ro.societateahermes.backendservice.service.TimelineServiceInterface;
import ro.societateahermes.backendservice.service.serviceImplementation.TimelineServiceImplementation;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/timeline")
public class TimelineControllerImplementation implements TimelineControllerInterface {

    private final TimelineServiceInterface timeLineService;

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
    public List<Timeline> getAll() {
        return timeLineService.getAll();
    }

    @DeleteMapping("/{IdTimeline}/{IdEvent}")
    @Override
    public void deleteEvenFromTimeline(@Valid @PathVariable("IdTimeline")  Long IdTimeline, @Valid @PathVariable("IdEvent")  Long IdEvent) {
        timeLineService.deleteEvenFromTimeline(IdTimeline, IdEvent);
    }
}


