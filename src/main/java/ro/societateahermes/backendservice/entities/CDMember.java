package ro.societateahermes.backendservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
public class CDMember {
    @Id
    @GeneratedValue
    private Long CDMemberID;
    @NotEmpty(message = "Image path cannot be null!")
    private String imagePath;
    @NotEmpty(message = "Facebook link cannot be null!")
    private String facebookLink;
    @NotEmpty(message = "Description is mandatory!")
    private String description;
    @NotEmpty(message = "Name is mandatory!")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name cannot contain numbers!")
    private String name;
    @NotEmpty(message = "Position is mandatory!")
    @Pattern(regexp = "[a-zA-Z]+", message = "Position cannot contain numbers!")
    private String position;

    public CDMember(Long CDMemberID, @NotEmpty(message = "Image path cannot be null!") String imagePath,
                    @NotEmpty(message = "Facebook link cannot be null!") String facebookLink,
                    @NotEmpty(message = "Description is mandatory!") String description,
                    @NotEmpty(message = "Name is mandatory!") String name,
                    @NotEmpty(message = "Position is mandatory!") String position) {
        this.CDMemberID = CDMemberID;
        this.description = description;
        this.imagePath = imagePath;
        this.name = name;
        this.position = position;
        this.facebookLink = facebookLink;
    }
}
