package ro.societateahermes.backendservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String to;
    private String recipientName;
    private String subject;
    private String text;

    public Email(String to, String recipientName, String subject) {
        this.to = to;
        this.recipientName = recipientName;
        this.subject = subject;
    }
}
