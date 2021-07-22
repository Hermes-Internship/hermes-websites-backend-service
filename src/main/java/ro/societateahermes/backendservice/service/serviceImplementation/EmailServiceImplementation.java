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

    @Scheduled(cron = "0 7 * * *")
    public void checkEvents(Integer daysBefore) {
        for (Event event : eventService.getAll()) {
            if (eventService.isDaysBeforeEvent(event, 3)) {
                this.sendReminderMessageForEvent(event, 3);
            } else if (eventService.isDaysBeforeEvent(event, 1)) {
                this.sendReminderMessageForEvent(event, 1);
            } else if (eventService.isDuringEvent(event)) {
                this.sendReminderMessageForEvent(event);
            }
        }
    }

    public void sendReminderMessageForEvent(Event event) {
        for (Participation participation : event.getListOfParticipation()) {
            User user = participation.getUser();
            String recipientName = user.getFirstName() + " " + user.getLastName();
            String to = user.getEmail();

            Email email = new Email(to, recipientName,
                    "Reminder pe parcursul evenimentului " + event.getEventName());
            this.sendReminderEmail(email);
        }
    }

    public void sendReminderMessageForEvent(Event event, Integer daysBefore) {
        // todo: make reminder-email.html
        for (Participation participation : event.getListOfParticipation()) {
            User user = participation.getUser();
            String recipientName = user.getFirstName() + " " + user.getLastName();
            String to = user.getEmail();

            Email email = new Email(to, recipientName, "Reminder pentru evenimentul " + event.getEventName(),
                    daysBefore);
            this.sendReminderEmail(email);
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

    public void sendReminderEmail(Email email) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("recipientName", email.getRecipientName());
        if (email.getDaysBefore() != null) {
            variables.put("daysBefore", email.getDaysBefore());
        }

        String replacedThymeleafTemplate = this.getReplacedThymeleafTemplate(variables, EmailTemplates.REMINDER);
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

    /*
    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               String ...templateModel) {
        String text = String.format(template.getText(), templateModel);
        sendSimpleMessage(to, subject, text);
    }

    @Override
    public void sendMessageWithAttachment(String to,
                                          String subject,
                                          String text,
                                          String pathToAttachment) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(NOREPLY_ADDRESS);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void sendMessageUsingFreemarkerTemplate(
            String to, String subject, Map<String, Object> templateModel)
            throws IOException, TemplateException, MessagingException {

        Template freemarkerTemplate = freemarkerConfigurer.getConfiguration().getTemplate("template-freemarker.ftl");
        String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, templateModel);

        sendHtmlMessage(to, subject, htmlBody);
    }*/


}
