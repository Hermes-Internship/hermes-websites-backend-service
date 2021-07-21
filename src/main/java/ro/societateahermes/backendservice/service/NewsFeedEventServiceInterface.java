package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;

import java.util.ArrayList;

public interface NewsFeedEventServiceInterface {

    ArrayList<NewsFeedDTO> getNewsFeedEvents();
    ArrayList<NewsFeedDTO> deleteEvent(Event event);
    ArrayList<NewsFeedDTO> updateEvent(Event event1,Event event2);
    ArrayList<NewsFeedDTO> createEvent(Event event);
}
