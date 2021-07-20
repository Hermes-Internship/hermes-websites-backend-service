package ro.societateahermes.backendservice.service;

import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.dto.EditionDto;

import java.util.List;

public interface EditionServiceInterface {
    List<EditionDto> getAll();

    void saveMediaToNewEdition(List<MultipartFile> images, List<MultipartFile> videos);

    void addMediaToEdition(Long editionId, List<MultipartFile> images, List<MultipartFile> videos);
}
