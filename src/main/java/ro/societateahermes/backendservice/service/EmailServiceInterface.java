package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Email;

public interface EmailServiceInterface {
    void sendSimpleMessage(Email email);

    void sendConfirmationEmail(Email email);
}
