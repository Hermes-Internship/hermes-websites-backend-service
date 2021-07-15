package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDMemberDTO {
    private String imagePath;
    private String description;
    private String name;
    private String position;
}
