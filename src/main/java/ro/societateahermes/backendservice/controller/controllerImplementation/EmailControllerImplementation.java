package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.societateahermes.backendservice.entities.Email;
import ro.societateahermes.backendservice.service.EmailServiceInterface;

import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailControllerImplementation {
    private final EmailServiceInterface emailService;

    public EmailControllerImplementation(EmailServiceInterface emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-simple")
    public void sendSimpleEmail() {
        emailService.sendSimpleMessage(new Email("chismatei@gmail.com", "Chis Matei",
                "Test subject"));
    }

    @PostMapping("/send-confirmation")
    public void sendConfirmationEmail() throws IOException {
        emailService.sendConfirmationEmail(new Email("chismatei@gmail.com", "Chis Matei",
                "Confirmation Email"));
    }

    @PostMapping("/check-events")
    public void checkEvents() {
        emailService.checkEvents();
    }
}
