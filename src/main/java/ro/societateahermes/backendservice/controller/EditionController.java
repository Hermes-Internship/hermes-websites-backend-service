package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.Image;
import ro.societateahermes.backendservice.entities.dto.EditionDto;
import ro.societateahermes.backendservice.service.serviceImplementation.EditionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/edition")
public class EditionController {
    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping
    public List<EditionDto> getAll() {
        List<Edition> editions = editionService.getAll();
        return editions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{editionId}/image")
    public List<Image> getImagesOfEdition(@PathVariable("editionId") Long editionId) {
        return editionService.getImagesOfEdition(editionId);
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

    private EditionDto convertToDto(Edition edition) {
        return new EditionDto(edition.getId(), edition.getImages(), edition.getVideos());
    }

    private Edition convertToEntity(EditionDto editionDto) {
        return new Edition(editionDto.getId(), editionDto.getImages(), editionDto.getVideos());
    }
}
