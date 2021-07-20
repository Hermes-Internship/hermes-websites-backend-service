package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping
    public void saveNewEditionWithMedia(@RequestParam(value = "image", required = false) List<MultipartFile> images,
                                        @RequestParam(value = "video", required = false) List<MultipartFile> videos) {
        // todo: test all 4 cases: 2 nulls, 0 null, 2 x 1 null
        if (images != null) {
            editionService.saveImagesToNewEdition(images);
        }
        if (videos != null) {
            editionService.saveVideosToNewEdition(videos);
        }
    }

    @PostMapping("/{editionId}")
    public void addMediaToEdition(@PathVariable("editionId") Long editionId,
                                  @RequestParam(value = "image", required = false) List<MultipartFile> images,
                                  @RequestParam(value = "video", required = false) List<MultipartFile> videos) {
        editionService.addMediaToEdition(editionId, images, videos);
    }
}
