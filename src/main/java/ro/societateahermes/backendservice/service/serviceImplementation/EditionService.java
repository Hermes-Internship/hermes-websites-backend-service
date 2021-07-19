package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.Image;
import ro.societateahermes.backendservice.entities.Video;
import ro.societateahermes.backendservice.repository.EditionRepository;
import ro.societateahermes.backendservice.repository.FileSystemRepository;
import ro.societateahermes.backendservice.repository.ImageRepository;
import ro.societateahermes.backendservice.repository.VideoRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionService {
    private final EditionRepository editionRepository;
    private final ImageRepository imageRepository;
    private final VideoRepository videoRepository;
    private final FileSystemRepository fileSystemRepository;

    public EditionService(EditionRepository editionRepository, ImageRepository imageRepository, VideoRepository videoRepository, FileSystemRepository fileSystemRepository) {
        this.editionRepository = editionRepository;
        this.imageRepository = imageRepository;
        this.videoRepository = videoRepository;
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

    public void saveImageToEdition(Long editionId, MultipartFile file) {
        try {
            fileSystemRepository.saveFile(file.getBytes(), "edition", file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Edition edition = editionRepository.findById(editionId).orElseThrow();
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

    public void saveMediaToNewEdition(List<MultipartFile> images, List<MultipartFile> videos) {
        List<Image> savedImages = this.saveImages(images);
        List<Video> savedVideos = this.saveVideos(videos);

        Edition edition = new Edition(savedImages, savedVideos);
        editionRepository.save(edition);

        for (Image savedImage : savedImages) {
            savedImage.setEdition(edition);
            imageRepository.save(savedImage);
        }

        for (Video savedVideo : savedVideos) {
            savedVideo.setEdition(edition);
            videoRepository.save(savedVideo);
        }
    }

    private List<Image> saveImages(List<MultipartFile> multipartFiles) {
        List<Image> images = new ArrayList<>();
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String originalFilename = multipartFile.getOriginalFilename();
                fileSystemRepository.saveFile(multipartFile.getBytes(), "edition", originalFilename);

                Image image = new Image("src/main/resources/edition/" + originalFilename);
                imageRepository.save(image);
                images.add(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return images;
    }

    private List<Video> saveVideos(List<MultipartFile> multipartFiles) {
        List<Video> videos = new ArrayList<>();
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String originalFilename = multipartFile.getOriginalFilename();
                fileSystemRepository.saveFile(multipartFile.getBytes(), "edition", originalFilename);

                Video video = new Video("src/main/resources/edition/" + originalFilename);
                videoRepository.save(video);
                videos.add(video);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return videos;
    }
}
