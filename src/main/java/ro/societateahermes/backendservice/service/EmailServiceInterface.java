package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.Email;

import java.io.IOException;

public interface EmailServiceInterface {
    void sendSimpleMessage(Email email);

    void sendConfirmationEmail(Email email) throws IOException;
}
