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

    /*
    in DTO I can also have the eventID to know whose form the event belongs to, but I think it would be better if
    it were a one to one relationship between form-event and form-activity....
    this way I can know each form to which the event belongs
     */
    private long eventId;


}