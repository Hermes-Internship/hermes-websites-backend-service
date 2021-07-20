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
    public void save(@RequestParam("image") List<MultipartFile> images,
                     @RequestParam("video") List<MultipartFile> videos) {
        editionService.saveMediaToNewEdition(images, videos);
    }

    @PostMapping("/{editionId}")
    public void uploadFile(@PathVariable("editionId") Long editionId,
                           @RequestParam("file") List<MultipartFile> files) {
        for (MultipartFile file : files) {
            editionService.saveImageToEdition(editionId, file);
        }
    }
}
