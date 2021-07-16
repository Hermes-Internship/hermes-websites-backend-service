package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.Image;
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
    public List<Edition> getAll() {
        return editionService.getAll();
    }

    @GetMapping("/{editionId}/image")
    public List<Image> getImagesOfEdition(@PathVariable("editionId") Long editionId) {
        return editionService.getImagesOfEdition(editionId);
    }

    @PostMapping
    public void save(@RequestBody Edition edition) {
        editionService.save(edition);
    }

    @PostMapping("/{editionId}")
    public void uploadFile(@PathVariable("editionId") Long editionId, @RequestBody MultipartFile file) {
        editionService.saveFile(editionId, file);
    }
}
