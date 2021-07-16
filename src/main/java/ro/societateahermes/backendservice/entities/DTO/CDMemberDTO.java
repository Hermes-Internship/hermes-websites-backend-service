package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDMemberDTO {
    @NotEmpty(message = "Image path cannot be null!")
    private String imagePath;
    @NotEmpty(message = "Description is mandatory!")
    private String description;
    @NotEmpty(message = "Name is mandatory!")
    private String name;
    @NotEmpty(message = "Position is mandatory!")
    private String position;
}
