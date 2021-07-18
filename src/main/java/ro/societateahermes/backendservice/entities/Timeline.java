package ro.societateahermes.backendservice.entities;

import lombok.Data;
import ro.societateahermes.backendservice.entities.DTO.EventDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Data
@Entity
public class Timeline {
    @Id
    @GeneratedValue
    private Long IdTimeline;
    @OneToMany(mappedBy = "timeline")
    private List<EventDTO> listOfEvents;
}
