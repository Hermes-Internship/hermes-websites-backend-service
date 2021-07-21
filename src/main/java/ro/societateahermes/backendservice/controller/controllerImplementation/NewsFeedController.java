package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.NewsFeedPost;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.service.serviceImplementation.NewsFeedServiceImplementation;

import java.util.List;


@RestController
@RequestMapping("/news")
public class NewsFeedController {

    private final NewsFeedServiceImplementation newsFeed;

    public NewsFeedController(NewsFeedServiceImplementation newsFeed){
        this.newsFeed = newsFeed;
    }

    @GetMapping
    public List<NewsFeedDTO> getNews(){
        return newsFeed.getAllPost();
    }
    @PostMapping
    public void saveEventToNewsFeed(@RequestBody NewsFeedPost post){
        newsFeed.createPost(post);
    }
    @DeleteMapping("/{newsId}")
    public void deleteEventFromNewsFeed(@PathVariable("newsId")Long id){
        newsFeed.deletePost(id);
    }
}