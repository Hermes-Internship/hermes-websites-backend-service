package ro.societateahermes.backendservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.EditionMediaDeletion;
import ro.societateahermes.backendservice.entities.EditionMediaUpload;
import ro.societateahermes.backendservice.entities.dto.EditionDto;
import ro.societateahermes.backendservice.service.serviceImplementation.EditionService;

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

//    @PostMapping
//    public void saveNewEditionWithMedia(@RequestParam(value = "image", required = false) List<MultipartFile> images,
//                                        @RequestParam(value = "video", required = false) List<MultipartFile> videos) {
//        // todo: replace the 2 list with a @RequestBody MediaUpload class
//
//        if (images != null) {
//            editionService.saveImagesToNewEdition(images);
//        }
//        if (videos != null) {
//            editionService.saveVideosToNewEdition(videos);
//        }
//
//
//        // todo: find if edition should be created without any image or video
//        // if it shouldn't, return a bad request
//    }

    @PostMapping
    public void saveNewEditionWithMedia(@ModelAttribute EditionMediaUpload editionMediaUpload) {
        List<MultipartFile> images = editionMediaUpload.getImages();
        List<MultipartFile> videos = editionMediaUpload.getVideos();

        if (images != null) {
            editionService.saveImagesToNewEdition(images);
        }
        if (videos != null) {
            editionService.saveVideosToNewEdition(videos);
        }

        // todo: find if edition should be created without any image or video
        // if it shouldn't, return a bad request
    }

//    @PostMapping("/{editionId}")
//    public ResponseEntity<Object> addMediaToEdition(@PathVariable("editionId") Long editionId,
//                                                    @RequestParam(value = "image", required = false) List<MultipartFile> images,
//                                                    @RequestParam(value = "video", required = false) List<MultipartFile> videos) {
//        // todo: replace the 2 list with a @RequestBody MediaUpload class
//
//        if (images == null && videos == null) {
//            return new ResponseEntity<>("No image or video sent", HttpStatus.BAD_REQUEST);
//        }
//
//        if (images != null) {
//            editionService.saveImagesToEdition(editionId, images);
//        }
//        if (videos != null) {
//            editionService.saveVideosToEdition(editionId, videos);
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping("/{editionId}")
    public ResponseEntity<Object> addMediaToEdition(@PathVariable("editionId") Long editionId,
                                                    @ModelAttribute EditionMediaUpload editionMediaUpload) {
        // todo: replace the 2 list with a @RequestBody MediaUpload class
        List<MultipartFile> images = editionMediaUpload.getImages();
        List<MultipartFile> videos = editionMediaUpload.getVideos();

        if (images == null && videos == null) {
            return new ResponseEntity<>("No image or video sent", HttpStatus.BAD_REQUEST);
        }

        if (images != null) {
            editionService.saveImagesToEdition(editionId, images);
        }
        if (videos != null) {
            editionService.saveVideosToEdition(editionId, videos);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping("/{editionId}")
//    public void removeMediaFromEdition(@PathVariable("editionId") Long editionId,
//                                       @RequestParam(value = "image_id", required = false) List<Long> imageIds,
//                                       @RequestParam(value = "video_id", required = false) List<Long> videoIds) {
//        // todo: replace the 2 list with a @RequestBody MediaDeletion class
//
//        editionService.deleteImages(editionId, imageIds);
//    }

    @DeleteMapping("/{editionId}")
    public void removeMediaFromEdition(@PathVariable("editionId") Long editionId,
                                       @ModelAttribute EditionMediaDeletion editionMediaDeletion) {
        // todo: replace the 2 list with a @RequestBody MediaDeletion class
        List<Long> imagesIds = editionMediaDeletion.getImagesIds();
        editionService.deleteImages(editionId, imagesIds);
    }
}
