package ro.societateahermes.backendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Image {
    public Image(String path) {
        this.path = path;
    }

    public Image(Edition edition, String path) {
        this.edition = edition;
        this.path = path;
    }

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "event_edition_id")
    private Edition edition;

    private String path;
}
