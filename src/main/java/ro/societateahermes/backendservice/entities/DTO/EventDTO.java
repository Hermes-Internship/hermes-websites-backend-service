package ro.societateahermes.backendservice.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    @Id
    @GeneratedValue
    private Long IdEvent;
    private String eventName;
    private LocalDateTime eventStartDate;
    private String location;
}
