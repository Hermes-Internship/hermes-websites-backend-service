package ro.societateahermes.backendservice.entities;

import lombok.Data;
import ro.societateahermes.backendservice.entities.dto.ActivityDTO;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
public class Timeline {
    @Id
    @GeneratedValue
    private Long IdTimeline;
    @OneToOne(mappedBy = "timeline")
    private Event event;
    @OneToMany(mappedBy = "timeline")
    private List<ActivityDTO> listOfActivities;
}
