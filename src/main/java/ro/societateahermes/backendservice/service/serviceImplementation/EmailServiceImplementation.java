package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import ro.societateahermes.backendservice.entities.*;
import ro.societateahermes.backendservice.service.EmailServiceInterface;
import ro.societateahermes.backendservice.service.EventServiceInterface;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImplementation implements EmailServiceInterface {
    //@Value("${spring.mail.username}")
    private static final String FROM = "hermesconnor1@gmail.com";

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    @Autowired
    private EventServiceInterface eventService;

    //@Autowired
    //private SimpleMailMessage template;

    @Scheduled(cron = "20 8 14 * * *")
    public void checkEventsScheduled() {
        for (Event event : eventService.getAll()) {
            if (eventService.isDaysBeforeEvent(event, 3)) {
                this.sendReminderMessageBeforeEvent(event, 3);
            } else if (eventService.isDaysBeforeEvent(event, 1)) {
                this.sendReminderMessageBeforeEvent(event, 1);
            } else if (eventService.isDuringEvent(event)) {
                this.sendReminderMessageDuringEvent(event);
            }
        }
    }

    public void checkEvents() {
        for (Event event : eventService.getAll()) {
            if (eventService.isDaysBeforeEvent(event, 3)) {
                this.sendReminderMessageBeforeEvent(event, 3);
            } else if (eventService.isDaysBeforeEvent(event, 1)) {
                this.sendReminderMessageBeforeEvent(event, 1);
            } else if (eventService.isDuringEvent(event)) {
                this.sendReminderMessageDuringEvent(event);
            }
        }
    }

    public void sendReminderMessageDuringEvent(Event event) {
        for (Participation participation : event.getListOfParticipation()) {
            User user = participation.getUser();
            String recipientName = user.getFirstName() + " " + user.getLastName();
            String to = user.getEmail();

            Email email = new Email(to, recipientName,
                    "Reminder pe parcursul evenimentului " + event.getEventName());

            Map<String, Object> optionalVariables = new HashMap<>();
            optionalVariables.put("eventName", event.getEventName());
            optionalVariables.put("eventLocation", event.getEventLocation());

            this.sendReminderEmail(email, optionalVariables, EmailTemplates.DURING_EVENT_REMINDER);
        }
    }

    public void sendReminderMessageBeforeEvent(Event event, Integer daysBefore) {
        for (Participation participation : event.getListOfParticipation()) {
            User user = participation.getUser();
            String recipientName = user.getFirstName() + " " + user.getLastName();
            String to = user.getEmail();

            Email email = new Email(to, recipientName, "Reminder pentru evenimentul " + event.getEventName(),
                    daysBefore);

            Map<String, Object> optionalVariables = new HashMap<>();
            optionalVariables.put("eventName", event.getEventName());
            optionalVariables.put("eventStartDate", event.getEventStartDate());
            optionalVariables.put("eventEndDate", event.getEventEndDate());
            optionalVariables.put("eventLocation", event.getEventLocation());

            this.sendReminderEmail(email, optionalVariables, EmailTemplates.BEFORE_EVENT_REMINDER);
        }
    }

    public void sendReminderEmail(Email email, Map<String, Object> optionalVariables, EmailTemplates emailTemplate) {
        optionalVariables.put("recipientName", email.getRecipientName());
        if (email.getDaysBefore() != null) {
            optionalVariables.put("daysBefore", email.getDaysBefore());
        }

        String replacedThymeleafTemplate = this.getReplacedThymeleafTemplate(optionalVariables, emailTemplate);
        this.sendHtmlMessage(email, replacedThymeleafTemplate);
    }

    public void sendConfirmationEmail(Email email) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("recipientName", email.getRecipientName());

        String replacedThymeleafTemplate = this.getReplacedThymeleafTemplate(variables, EmailTemplates.CONFIRMATION);
        this.sendHtmlMessage(email, replacedThymeleafTemplate);
    }

    public String getReplacedThymeleafTemplate(Map<String, Object> templateModel, EmailTemplates emailTemplate) {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        return thymeleafTemplateEngine.process(emailTemplate.getTemplateName(), thymeleafContext);
    }

    private void sendHtmlMessage(Email email, String templateContent) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(FROM);
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(templateContent, true);
//          helper.addInline("attachment.png", resourceFile);
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendSimpleMessage(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(FROM);
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText("Test description");
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
