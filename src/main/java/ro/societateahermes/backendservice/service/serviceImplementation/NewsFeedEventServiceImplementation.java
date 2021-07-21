package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.repository.EventRepositoryInterface;
import ro.societateahermes.backendservice.service.NewsFeedEventServiceInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class NewsFeedEventServiceImplementation implements NewsFeedEventServiceInterface {

    private final EventRepositoryInterface eventRepository;

    @Autowired
    public NewsFeedEventServiceImplementation(EventRepositoryInterface eventRepository){
        this.eventRepository = eventRepository;
    }

    public ArrayList<NewsFeedDTO> getNewsFeedEvents(){

        ArrayList<Event> allEvents = (ArrayList<Event>) eventRepository.findAll();
        ArrayList<NewsFeedDTO> newsFeedNotifications = new ArrayList<>();

        for(Event event: allEvents){
            File file = new File(event.getImagePath());
            try {
                if(file.createNewFile()){
                    System.out.println("Could not create file");
                }else{
                    System.out.println("File already exist");
                }
            } catch (IOException e) {
                System.out.println("ERROR creating file");
                e.printStackTrace();
            }
            NewsFeedDTO notification = new NewsFeedDTO(file,event.getEventDescription(),event.getEventLink());
            newsFeedNotifications.add(notification);
        }
        return newsFeedNotifications;
    }

    public ArrayList<NewsFeedDTO> deleteEvent(Event event){
        eventRepository.delete(event);
        return getNewsFeedEvents();
    }

    public ArrayList<NewsFeedDTO> updateEvent(Event eventToUpdate,Event newDataEvent){
        eventRepository.delete(eventToUpdate);
        eventRepository.save(newDataEvent);
        return getNewsFeedEvents();
    }

    public ArrayList<NewsFeedDTO> createEvent(Event event){
        eventRepository.save(event);
        return getNewsFeedEvents();
    }
}
