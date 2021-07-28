package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.exceptions.UnathorizeException;
import ro.societateahermes.backendservice.service.serviceImplementation.NewsFeedServiceImplementation;
import ro.societateahermes.backendservice.utils.PermissionChecker;
import ro.societateahermes.backendservice.utils.RolesActiveUser;

import java.util.List;


@RestController
@RequestMapping("/news")
public class NewsFeedController {

    private final NewsFeedServiceImplementation newsFeed;

    public NewsFeedController(NewsFeedServiceImplementation newsFeed) {
        this.newsFeed = newsFeed;
    }

    @GetMapping
    public List<NewsFeedDTO> getNews() {
        return newsFeed.getAllPost();
    }

    @PostMapping("/{eventId}")
    public void saveEventToNewsFeed(@PathVariable("eventId") long eventId, @RequestBody NewsFeedDTO post) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventId, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        newsFeed.createPost(post);
    }

    @DeleteMapping("/{eventId}/{newsId}")
    public void deleteEventFromNewsFeed(@PathVariable("eventId") long eventId, @PathVariable("newsId") Long id) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventId, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        newsFeed.deletePost(id);
    }
}