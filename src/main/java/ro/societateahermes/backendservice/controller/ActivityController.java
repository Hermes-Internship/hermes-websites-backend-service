package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Activity;
import ro.societateahermes.backendservice.entities.DTO.ActivityDTO;
import ro.societateahermes.backendservice.service.ActivityServiceInterface;
import ro.societateahermes.backendservice.service.serviceImplementation.ActivityServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController implements ActivityControllerInterface{
    private ActivityServiceInterface activityService;

    public ActivityController(ActivityServiceImplementation activityService){
        this.activityService = activityService;
    }

    @PostMapping
    public void save(@RequestBody ActivityDTO activityDTO) {
        activityService.save(activityDTO);
    }

    @GetMapping
    public List<ActivityDTO> getAll() {
        return activityService.getAllActivities();
    }

    @DeleteMapping("/{activityId}")
    public void delete(@PathVariable("activityId") Long activityId) {
        activityService.delete(activityId);
    }

    @PutMapping("/update")
    public void put(@RequestBody ActivityDTO activityDTO) {
        activityService.update(activityDTO);
    }
}
