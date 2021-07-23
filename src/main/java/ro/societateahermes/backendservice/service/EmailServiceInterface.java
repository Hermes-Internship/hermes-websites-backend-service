package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Email;
import ro.societateahermes.backendservice.entities.Event;

import java.io.IOException;

public interface EmailServiceInterface {
    void sendSimpleMessage(Email email);

    void sendConfirmationEmail(Email email) throws IOException;

    void sendReminderMessageBeforeEvent(Event event, Integer daysBefore);

    void checkEvents();
}
