package ro.societateahermes.backendservice.entities.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.societateahermes.backendservice.entities.Event;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @OneToOne(mappedBy = "form")
    private Event event;

    @JsonManagedReference
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Question> questions;
}
