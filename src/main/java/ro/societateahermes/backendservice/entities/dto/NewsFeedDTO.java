package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsFeedDTO {

    private String eventImagePath;
    private String eventDescription;
    private String eventLink;
}
