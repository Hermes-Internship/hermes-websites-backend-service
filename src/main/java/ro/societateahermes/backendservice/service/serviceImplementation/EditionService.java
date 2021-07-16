package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.Image;
import ro.societateahermes.backendservice.repository.EditionRepository;
import ro.societateahermes.backendservice.repository.FileSystemRepository;
import ro.societateahermes.backendservice.repository.ImageRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionService {
    private final EditionRepository editionRepository;
    private final ImageRepository imageRepository;
    private final FileSystemRepository fileSystemRepository;

    public EditionService(EditionRepository editionRepository, ImageRepository imageRepository, FileSystemRepository fileSystemRepository) {
        this.editionRepository = editionRepository;
        this.imageRepository = imageRepository;
        this.fileSystemRepository = fileSystemRepository;
    }

    public List<Edition> getAll() {
        return editionRepository.findAll();
    }

    public void save(Edition edition) {
        for (Image image : edition.getImages()) {
            image.setPath("src/main/resources/" + edition.getId() + "/" + image.getPath());
            imageRepository.save(image);
        }

        editionRepository.save(edition);
    }

    public void saveFile(Long editionId, MultipartFile file) {
        try {
            fileSystemRepository.saveFile(file.getBytes(), "edition", file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Edition edition = editionRepository.findById(editionId).get();
        Image image = new Image(edition, "src/main/resources/edition/" + file.getOriginalFilename());
        imageRepository.save(image);
        edition.addImage(image);
    }

    public List<Image> getImagesOfEdition(Long editionId) {
        return imageRepository.findAll()
                .stream()
                .filter(image -> image.getEdition().getId().equals(editionId))
                .collect(Collectors.toList());
    }
}
