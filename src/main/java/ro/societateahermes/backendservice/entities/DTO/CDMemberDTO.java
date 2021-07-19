package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDMemberDTO {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Image path cannot be null!")
    private String imagePath;
    @NotEmpty(message = "Facebook link cannot be null!")
    private String facebookLink;
    @NotEmpty(message = "Description is mandatory!")
    private String description;
    @Pattern(regexp = "[a-zA-Z]+", message = "Name cannot contain numbers or special characters!")
    @NotBlank(message = "Name is mandatory!")
    private String name;
    @NotBlank(message = "Position is mandatory!")
    private String position;
}
