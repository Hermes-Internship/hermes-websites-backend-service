package ro.societateahermes.backendservice.entities.form;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Option {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String label;
}
