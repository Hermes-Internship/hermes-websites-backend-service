package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.societateahermes.backendservice.entities.Event;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private Long IdActivity;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    private String activityName;
    private String activityDescription;
    private LocalDateTime activityStartDate;
    private String activityEstimatedTime;
    private LocalDateTime activityEndDate;
    private int maximumNumberOfParticipants;
    private String activityLink;

}
