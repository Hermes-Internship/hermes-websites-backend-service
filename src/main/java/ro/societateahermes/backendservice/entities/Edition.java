package ro.societateahermes.backendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Edition {
    @Id
    @GeneratedValue
    private Long id;

    public Edition(List<Image> images, List<Video> videos) {
        this.images = images;
        this.videos = videos;
    }

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

    public void addVideo(Video video) {
        videos.add(video);
    }
}
