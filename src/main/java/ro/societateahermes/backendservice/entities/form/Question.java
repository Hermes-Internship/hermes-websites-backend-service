package ro.societateahermes.backendservice.entities.form;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    private String label;

    private Integer questionTypeId;

    @ElementCollection
    private List<String> options;

    public QuestionType getQuestionType() {
        return QuestionType.getType(questionTypeId);
    }

    public void setQuestionType(QuestionType questionType) {
        if (questionType == null) {
            this.questionTypeId = null;
        } else {
            this.questionTypeId = questionType.getId();
        }
    }

    public enum QuestionType {
        SHORT_ANSWER(1),
        LONG_ANSWER(2),
        SINGLE_CHOICE(3),
        MULTIPLE_CHOICE(4);

        private final int id;

        QuestionType(int id) {
            this.id = id;
        }

        public static QuestionType getType(Integer id) {
            if (id == null) {
                return null;
            }

            for (QuestionType questionType : QuestionType.values()) {
                if (id.equals(questionType.getId())) {
                    return questionType;
                }
            }

            throw new IllegalArgumentException("No matching question type for id " + id);
        }

        public int getId() {
            return id;
        }
    }
}


