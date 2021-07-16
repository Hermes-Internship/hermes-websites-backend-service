package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long ID;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String university;
    private String password;
    private String yearOfStudy;
    private String field;
    private String language;
}
