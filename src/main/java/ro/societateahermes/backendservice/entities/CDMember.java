package ro.societateahermes.backendservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class CDMember {
    @Id
    @GeneratedValue
    private Long CDMemberID;
    private String imagePath; /// to be made
    private String facebookLink;
    private String description;
    private String name;
    private String position;

}
