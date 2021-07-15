package ro.societateahermes.backendservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Data
@Entity
public class TimeLine {
    @Id
    @GeneratedValue
    private Long IdTimeLine;
    @OneToMany(mappedBy = "timeline")
    private List<Event> listOfEvents;
}
