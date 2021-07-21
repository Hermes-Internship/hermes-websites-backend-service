package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.NewsFeedServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsFeedServiceImplementation implements NewsFeedServiceInterface {

    private final EventRepositoryInterface eventRepository;

    public NewsFeedServiceImplementation(EventRepositoryInterface eventRepository){
        this.eventRepository = eventRepository;
    }

    public List<NewsFeedDTO> getAllNotificationsForNewsFeed(){

        List<NewsFeedDTO> newsFeedNotifications = new ArrayList<>();
        List<Event> allEvents = eventRepository.findAll();
        for(Event event:allEvents){
            NewsFeedDTO newsFeedDTO = new NewsFeedDTO("",event.getEventDescription(),event.getEventLink());
            newsFeedNotifications.add(newsFeedDTO);
        }
        return newsFeedNotifications;
    }

    public void createEvent(Event event){
        eventRepository.save(event);
    }

    public void deleteEvent(Long id){
        eventRepository.delete(eventRepository.findById(id).orElseThrow());
    }

    public void updateEvent(Event eventOutdated,Event eventUpdated){
        eventRepository.delete(eventOutdated);
        eventRepository.save(eventUpdated);
    }
}
