package ro.societateahermes.backendservice.service;

public interface EmailServiceInterface {
    void sendSimpleMessage(String to, String subject, String text);
}
