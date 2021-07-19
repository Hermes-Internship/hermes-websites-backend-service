package ro.societateahermes.backendservice.entities.DTO;

import lombok.Data;
import ro.societateahermes.backendservice.entities.form.Question;

import java.util.List;

@Data
public class FormDto {
    private Long id;

    private List<Question> questions;
}
