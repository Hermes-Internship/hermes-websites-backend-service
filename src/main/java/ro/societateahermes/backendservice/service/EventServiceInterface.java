package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Participation;
import ro.societateahermes.backendservice.entities.User;

public interface EventServiceInterface {

    void addParticipation(long eventID, Participation participation);
}
