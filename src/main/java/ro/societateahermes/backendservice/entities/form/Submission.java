package ro.societateahermes.backendservice.entities.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Submission {

    @Id
    @GeneratedValue
    private long id;

    public Submission(Form form, List<Answer> answers)
    {
        this.form=form;
        this.answers=answers;
    }

    @OneToOne
    @JoinColumn(name = "form_id")
    private Form form;

    @OneToMany(mappedBy = "submission")
    private List<Answer> answers;
}
