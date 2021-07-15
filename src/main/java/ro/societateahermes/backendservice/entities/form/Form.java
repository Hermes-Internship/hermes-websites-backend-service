package ro.societateahermes.backendservice.entities.form;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Form {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "form")
    private List<Question> questions;
}
