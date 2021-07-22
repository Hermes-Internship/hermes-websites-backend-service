package ro.societateahermes.backendservice.service;

import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.dto.EditionDto;

import java.util.List;

public interface EditionServiceInterface {
    List<EditionDto> getAll();

//    void saveImagesToNewEdition(List<MultipartFile> images);

//    void saveVideosToNewEdition(List<MultipartFile> videos);

    void saveImagesToEdition(Long editionId, List<MultipartFile> multipartImages);

    void saveVideosToEdition(Long editionId, List<MultipartFile> multipartVideos);

    void deleteImagesFromEdition(Long editionId, List<Long> imageIds);
}
