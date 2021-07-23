package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.societateahermes.backendservice.entities.EditionImage;
import ro.societateahermes.backendservice.entities.EditionVideo;

import java.util.List;

@Data
@AllArgsConstructor
public class EditionDto {
    private Long id;

//    private Event event;

    private List<EditionImage> images;

    private List<EditionVideo> videos;
}
