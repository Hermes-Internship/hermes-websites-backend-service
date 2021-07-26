package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.TimelineControllerInterface;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;
import ro.societateahermes.backendservice.entities.dto.TimelineDTO;
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


    @PostMapping("/{IdEvent}")
    @Override
    public TimelineDTO createActivityFromTimeline(@Valid @PathVariable("IdEvent") Long IdEvent, @Valid @RequestBody ActivityDTO activityDTO) {
         return timeLineService.createActivityFromTimeline(IdEvent, activityDTO);
    }

    @PutMapping("/{IdEvent}")
    @Override
    public TimelineDTO updateActivityFromTimeline(@Valid @PathVariable("IdEvent") Long IdEvent, @Valid @RequestBody ActivityDTO activityDTO) {
        return timeLineService.updateActivityFromTimeline(IdEvent, activityDTO);
    }

    @DeleteMapping("/{IdEvent}")
    @Override
    public void deleteActivityFromTimeline(@Valid @PathVariable("IdEvent")  Long IdEvent, @Valid @RequestBody ActivityDTO IdActivity) {
        timeLineService.deleteActivityFromTimeline(IdEvent, IdActivity);
    }

    @GetMapping("/{IdEvent}/{IdActivity}")
    @Override
    public ActivityDTO getOneActivityFromTimeline(@Valid @PathVariable("IdEvent") Long IdEvent, @Valid @PathVariable("IdActivity") Long IdActivity) {
        return timeLineService.getOneActivityFromTimeline(IdEvent, IdActivity);
    }

    @GetMapping
    @Override
    public List<TimelineDTO> getAllActivityFromTimeline() {
        return timeLineService.getAllActivityFromTimeline();
    }

    @GetMapping("/{IdEvent}")
    @Override
    public List<ActivityDTO> getAllActivityFromTimelineOrderByDateAndTime(@Valid @PathVariable("IdEvent") Long IdEvent) {
        return timeLineService.orderActivityByDateAndTime(IdEvent);
    }

//    @GetMapping("/{IdEvent}")
//    @Override
//    public TimelineDTO getOneTimeline(@Valid @PathVariable("IdEvent") Long IdEvent) {
//        return timeLineService.getTimelineOfEvent(IdEvent);
//    }
}


