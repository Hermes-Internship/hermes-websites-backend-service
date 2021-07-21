package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.service.serviceImplementation.NewsFeedServiceImplementation;

import java.util.List;


@RestController
@RequestMapping("/newsFeed")
public class NewsFeedController {

    private final NewsFeedServiceImplementation newsFeed;

    public NewsFeedController(NewsFeedServiceImplementation newsFeed){
        this.newsFeed = newsFeed;
    }

    @GetMapping
    public List<NewsFeedDTO> getNews(){
        return newsFeed.getAllNotificationsForNewsFeed();
    }
    @PostMapping
    public void saveEventToNewsFeed(@RequestBody Event event){
        newsFeed.createEvent(event);
    }
    @DeleteMapping("/{eventId}")
    public void deleteEventFromNewsFeed(@PathVariable("eventId")Long id){
        newsFeed.deleteEvent(id);
    }
}