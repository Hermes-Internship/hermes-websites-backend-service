package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDMemberDTO {
    private Long id;
    @NotEmpty(message = "Image path cannot be null!")
    private String imagePath;
    @NotEmpty(message = "Facebook link cannot be null!")
    private String facebookLink;
    @NotEmpty(message = "Description is mandatory!")
    private String description;
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name cannot contain numbers or special characters!")
    @NotBlank(message = "Name is mandatory!")
    private String name;
    @NotBlank(message = "Position is mandatory!")
    private String position;
}
