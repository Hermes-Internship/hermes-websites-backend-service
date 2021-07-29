package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.dto.FullActivityDTO;
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
    public void save(@RequestBody FullActivityDTO fullActivityDTO) {
        activityService.save(fullActivityDTO);
    }

    @GetMapping
    public List<FullActivityDTO> getAll() {
        return activityService.getAllActivities();
    }

    @DeleteMapping("/{activityId}")
    public void delete(@PathVariable("activityId") Long activityId) {
        activityService.delete(activityId);
    }

    @PutMapping("/update")
    public void put(@RequestBody FullActivityDTO fullActivityDTO) {
        activityService.update(fullActivityDTO);
    }
}
