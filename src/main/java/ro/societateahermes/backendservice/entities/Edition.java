package ro.societateahermes.backendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Edition {
    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne
//    @JoinColumn("event_id")
//    private Event event;

    @JsonManagedReference
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private List<Image> images;

    @JsonManagedReference
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private List<Video> videos;

    public void addImage(Image image) {
        images.add(image);
    }
}
