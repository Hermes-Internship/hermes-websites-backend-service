package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.societateahermes.backendservice.entities.form.Answer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySubmissionDTO {

    //fields related to the user
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String university;
    private String password;

    //fields related to the submission of the form
    private long formId;
    private List<Answer> answers;

    //fields related to the event
    private long eventId;


}