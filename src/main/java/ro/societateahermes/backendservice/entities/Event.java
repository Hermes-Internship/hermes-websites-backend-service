package ro.societateahermes.backendservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long IdEvent;
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventStartDate;
    private String eventEstimatedTime;
    private LocalDateTime eventEndDate;
    private String eventLink;
    @OneToMany(mappedBy = "event")
    private List<Activity> listOfActivities;

}
