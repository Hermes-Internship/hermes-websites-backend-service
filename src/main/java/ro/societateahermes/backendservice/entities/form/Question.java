package ro.societateahermes.backendservice.entities.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    private String label;

    private Integer questionTypeId;

    @JsonManagedReference
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Option> options;

    public QuestionType getQuestionType() {
        return QuestionType.getType(questionTypeId);
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionTypeId = questionType == null ? null : questionType.getId();
    }
}


