package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.societateahermes.backendservice.entities.Image;
import ro.societateahermes.backendservice.entities.Video;

import java.util.List;

@Data
@AllArgsConstructor
public class EditionDto {
    private Long id;

//    private Event event;

    private List<Image> images;

    private List<Video> videos;
}
