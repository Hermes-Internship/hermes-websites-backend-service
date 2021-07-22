package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.societateahermes.backendservice.service.EmailServiceInterface;

@RestController
@RequestMapping("/email")
public class EmailControllerImplementation {
    private final EmailServiceInterface emailService;

    public EmailControllerImplementation(EmailServiceInterface emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void sendEmail() {
        emailService.sendSimpleMessage("chismatei@gmail.com", "Test subject", "Test description");
    }
}
