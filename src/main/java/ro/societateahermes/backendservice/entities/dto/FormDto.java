package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.societateahermes.backendservice.entities.form.Question;

import java.util.List;

@Data
@AllArgsConstructor
public class FormDto {
    private Long id;

    private List<Question> questions;
}
