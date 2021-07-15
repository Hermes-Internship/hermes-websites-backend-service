package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.TimeLineControllerInterface;
import ro.societateahermes.backendservice.entities.TimeLine;
import ro.societateahermes.backendservice.service.TimeLineServiceInterface;
import ro.societateahermes.backendservice.service.serviceImplementation.TimeLineServiceImplementation;

import java.util.List;


@RestController
@RequestMapping("/timeline")
public class TimeLineControllerImplementation implements TimeLineControllerInterface {

    private final TimeLineServiceInterface timeLineService;

    public TimeLineControllerImplementation(TimeLineServiceImplementation timeLineService) {
        this.timeLineService = timeLineService;
    }


    @PostMapping
    @Override
    public void save(@RequestBody TimeLine timeLine) {
        timeLineService.save(timeLine);
    }

    @GetMapping
    @Override
    public List<TimeLine> getAll() {
        return timeLineService.getAll();
    }

    @DeleteMapping("/{IdTimeLine}")
    @Override
    public void delete(@PathVariable("IdTimeLine")  Long IdTimeLine) {
        timeLineService.delete(IdTimeLine);
    }
}


