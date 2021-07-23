package ro.societateahermes.backendservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.EditionMediaDeletion;
import ro.societateahermes.backendservice.entities.EditionMediaUpload;
import ro.societateahermes.backendservice.entities.dto.EditionDto;
import ro.societateahermes.backendservice.service.serviceImplementation.EditionService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/edition")
public class EditionController {
    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping
    public List<EditionDto> getAll() {
        return editionService.getAll();
    }

    @PostMapping
    public void saveNewEditionWithMedia(@ModelAttribute EditionMediaUpload editionMediaUpload) {
        List<MultipartFile> images = editionMediaUpload.getImages();
        List<MultipartFile> videos = editionMediaUpload.getVideos();

        Long newEditionId = editionService.createEmptyEdition().getId();
        if (images != null) {
            editionService.saveImagesToEdition(newEditionId, images);
        }
        if (videos != null) {
            editionService.saveVideosToEdition(newEditionId, videos);
        }
    }

    @DeleteMapping("/{editionId}")
    public void deleteEdition(@PathVariable("editionId") Long editionId) throws IOException {
        editionService.deleteEdition(editionId);
    }

    @PostMapping("/{editionId}/media")
    public ResponseEntity<Object> addMediaToEdition(@PathVariable("editionId") Long editionId,
                                                    @ModelAttribute EditionMediaUpload editionMediaUpload) {
        List<MultipartFile> images = editionMediaUpload.getImages();
        List<MultipartFile> videos = editionMediaUpload.getVideos();

        if (images == null && videos == null) {
            return new ResponseEntity<>("No image or video sent", HttpStatus.BAD_REQUEST);
        }

        if (images != null && videos != null) {
            editionService.saveMediaToEdition(editionId, images, videos);
        } else if (images != null) {
            editionService.saveImagesToEdition(editionId, images);
        } else {
            editionService.saveVideosToEdition(editionId, videos);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{editionId}/media")
    public ResponseEntity<Object> deleteMediaFromEdition(@PathVariable("editionId") Long editionId,
                                                         @RequestBody EditionMediaDeletion editionMediaDeletion) throws IOException, URISyntaxException {
        List<Long> imagesIds = editionMediaDeletion.getImagesIds();
        List<Long> videosIds = editionMediaDeletion.getVideosIds();

        if (imagesIds == null && videosIds == null) {
            return new ResponseEntity<>("No image or video sent", HttpStatus.BAD_REQUEST);
        }

        if (imagesIds != null && videosIds != null) {
            editionService.deleteMediaFromEdition(editionId, imagesIds, videosIds);
        } else if (imagesIds != null) {
            editionService.deleteImagesFromEdition(editionId, imagesIds);
        } else {
            editionService.deleteVideosFromEdition(editionId, videosIds);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
