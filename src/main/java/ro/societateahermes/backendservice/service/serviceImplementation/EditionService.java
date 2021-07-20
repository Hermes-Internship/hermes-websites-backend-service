package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.Image;
import ro.societateahermes.backendservice.entities.Video;
import ro.societateahermes.backendservice.entities.dto.EditionDto;
import ro.societateahermes.backendservice.entities.mapper.EditionMapper;
import ro.societateahermes.backendservice.repository.EditionRepository;
import ro.societateahermes.backendservice.repository.FileSystemRepository;
import ro.societateahermes.backendservice.repository.ImageRepository;
import ro.societateahermes.backendservice.repository.VideoRepository;
import ro.societateahermes.backendservice.service.EditionServiceInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionService implements EditionServiceInterface {
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

    public List<EditionDto> getAll() {
        List<Edition> editions = editionRepository.findAll();
        return editions.stream()
                .map(EditionMapper::convertToDto)
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

    public void saveImagesToNewEdition(List<MultipartFile> images) {
        List<Image> savedImages = this.saveImages(images);

        Edition edition = new Edition(savedImages, null);
        editionRepository.save(edition);

        for (Image savedImage : savedImages) {
            savedImage.setEdition(edition);
            imageRepository.save(savedImage);
        }
    }

    public void saveVideosToNewEdition(List<MultipartFile> videos) {
        List<Video> savedVideos = this.saveVideos(videos);

        Edition edition = new Edition(null, savedVideos);
        editionRepository.save(edition);

        for (Video savedVideo : savedVideos) {
            savedVideo.setEdition(edition);
            videoRepository.save(savedVideo);
        }
    }

    public void addMediaToEdition(Long editionId, List<MultipartFile> images, List<MultipartFile> videos) {
        this.saveImages(editionId, images);
        this.saveVideos(editionId, videos);
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

    private void saveImages(Long editionId, List<MultipartFile> multipartImages) {
        Edition edition = editionRepository.findById(editionId).orElseThrow();

        try {
            for (MultipartFile multipartImage : multipartImages) {
                String originalFilename = multipartImage.getOriginalFilename();
                fileSystemRepository.saveFile(multipartImage.getBytes(), "edition", originalFilename);

                Image image = new Image(edition, "src/main/resources/edition/" + originalFilename);
                imageRepository.save(image);
                edition.addImage(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void saveVideos(Long editionId, List<MultipartFile> multipartVideos) {
        Edition edition = editionRepository.findById(editionId).orElseThrow();

        try {
            for (MultipartFile multipartVideo : multipartVideos) {
                String originalFilename = multipartVideo.getOriginalFilename();
                fileSystemRepository.saveFile(multipartVideo.getBytes(), "edition", originalFilename);

                Video video = new Video(edition, "src/main/resources/edition/" + originalFilename);
                videoRepository.save(video);
                edition.addVideo(video);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
