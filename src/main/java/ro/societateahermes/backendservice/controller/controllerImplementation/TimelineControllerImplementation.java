package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.TimelineControllerInterface;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
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
    public Timeline createActivityFromTimeline(@Valid @RequestBody Long IdEvent, ActivityDTO activityDTO) {
         return timeLineService.createActivityFromTimeline(IdEvent, activityDTO);
    }

    @Override
    public Timeline updateActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO) {
        return timeLineService.updateActivityFromTimeline(IdEvent, activityDTO);
    }

    @GetMapping
    @Override
    public List<ActivityDTO> getAllActivityFromTimeline(Timeline timeline) {
        return timeLineService.orderActivityByDateAndTime(timeline);
    }

    @DeleteMapping("/{IdEvent}")
    @Override
    public void deleteActivityFromTimeline(@Valid @PathVariable("IdEvent")  Long IdEvent, @Valid @RequestBody ActivityDTO IdActivity) {
        timeLineService.deleteActivityFromTimeline(IdEvent, IdActivity);
    }

    @Override
    public ActivityDTO getOneActivityFromTimeline(Long IdEvent, ActivityDTO activityDTO) {
        return timeLineService.getOneActivityFromTimeline(IdEvent, activityDTO);
    }
}


