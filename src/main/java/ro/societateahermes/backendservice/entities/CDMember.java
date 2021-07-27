package ro.societateahermes.backendservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CDMember {
    @Id
    @GeneratedValue
    private Long CDMemberID;
    private String imagePath;
    private String facebookLink;
    private String description;
    private String name;
    private String position;
}
