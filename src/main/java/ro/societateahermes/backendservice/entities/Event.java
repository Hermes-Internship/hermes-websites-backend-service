package ro.societateahermes.backendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.societateahermes.backendservice.entities.form.Form;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private String eventLocation;
    @OneToMany(mappedBy = "event")
    private List<Activity> listOfActivities = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<Participation> listOfParticipation = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "event")
    private List<Edition> editions = new ArrayList<>();
    @OneToMany(mappedBy = "event")
    private List<Sponsor> sponsorList;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id")
    private Form form;
}
