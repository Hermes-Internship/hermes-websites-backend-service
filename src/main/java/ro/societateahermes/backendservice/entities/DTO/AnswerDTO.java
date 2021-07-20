package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {

    private long idAnswer;

    private List<String> textAnswer;
}
