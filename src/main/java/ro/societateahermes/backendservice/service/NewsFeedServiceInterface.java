package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;

import java.util.List;

public interface NewsFeedServiceInterface {

    List<NewsFeedDTO> getAllNotificationsForNewsFeed();
    void createEvent(Event event);
    void deleteEvent(Long id);
    void updateEvent(Event eventOutdated,Event eventUpdated);
}
