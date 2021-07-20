package ro.societateahermes.backendservice.entities.mapper;

import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.dto.EditionDto;

public class EditionMapper {
    public static EditionDto convertToDto(Edition edition) {
        return new EditionDto(edition.getId(), edition.getImages(), edition.getVideos());
    }

    public static Edition convertToEdition(EditionDto editionDto) {
        return new Edition(editionDto.getId(), editionDto.getImages(), editionDto.getVideos());
    }
}
