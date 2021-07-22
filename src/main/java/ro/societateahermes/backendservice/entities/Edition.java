package ro.societateahermes.backendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Edition {
    @JsonManagedReference
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @Id
    @GeneratedValue
    private Long id;

    //    @ManyToOne
//    @JoinColumn("event_id")
//    private Event event;
    @JsonManagedReference
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos;

    public Edition() {
        images = new ArrayList<>();
        videos = new ArrayList<>();
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void removeImage(Image image) {
        images.remove(image);
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void removeVideo(Video video) {
        videos.remove(video);
    }
}
