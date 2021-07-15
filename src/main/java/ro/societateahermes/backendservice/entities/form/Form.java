package ro.societateahermes.backendservice.entities.form;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Form {
    @Id
    @GeneratedValue
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Question> questions;
}
