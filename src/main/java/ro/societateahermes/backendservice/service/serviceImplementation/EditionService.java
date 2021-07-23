package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Edition;
import ro.societateahermes.backendservice.entities.EditionImage;
import ro.societateahermes.backendservice.entities.EditionVideo;
import ro.societateahermes.backendservice.entities.ImageType;
import ro.societateahermes.backendservice.entities.dto.EditionDto;
import ro.societateahermes.backendservice.entities.mapper.EditionMapper;
import ro.societateahermes.backendservice.repository.EditionImageRepository;
import ro.societateahermes.backendservice.repository.EditionRepository;
import ro.societateahermes.backendservice.repository.FileSystemRepository;
import ro.societateahermes.backendservice.repository.VideoRepository;
import ro.societateahermes.backendservice.service.EditionServiceInterface;
import ro.societateahermes.backendservice.service.ImageServiceInterface;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionService implements EditionServiceInterface {
    private final EditionRepository editionRepository;
    private final EditionImageRepository imageRepository;
    private final VideoRepository videoRepository;
    private final ImageServiceInterface imageService;

    public EditionService(EditionRepository editionRepository, EditionImageRepository imageRepository, VideoRepository videoRepository, FileSystemRepository fileSystemRepository, ImageServiceInterface imageService) {
        this.editionRepository = editionRepository;
        this.imageRepository = imageRepository;
        this.videoRepository = videoRepository;
        this.imageService = imageService;
    }

    public List<EditionDto> getAll() {
        List<Edition> editions = editionRepository.findAll();
        return editions.stream()
                .map(EditionMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public Edition createEmptyEdition() {
        return editionRepository.save(new Edition());
    }

    public void deleteEdition(Long editionId) throws IOException {
        this.deleteImagesFromEdition(editionId);
        editionRepository.delete(editionRepository.findById(editionId).orElseThrow());
    }

    @Transactional
    public void saveMediaToEdition(Long editionId, List<MultipartFile> multipartImages, List<MultipartFile> multipartVideos) {
        this.saveImagesToEdition(editionId, multipartImages);
        this.saveVideosToEdition(editionId, multipartVideos);
    }

    public void saveImagesToEdition(Long editionId, List<MultipartFile> multipartImages) {
        Edition edition = editionRepository.findById(editionId).orElseThrow();

        try {
            for (MultipartFile multipartImage : multipartImages) {
//                String originalFilename = multipartImage.getOriginalFilename();
//                fileSystemRepository.saveFile(multipartImage.getBytes(), "edition", originalFilename);
                String imagePath = imageService.convertMultiPartToFile(multipartImage, ImageType.EDITION);
//                FileUtils.saveFileToResources(multipartImage.getBytes(), "edition", originalFilename);


                EditionImage image = new EditionImage(edition, imagePath);
                imageRepository.save(image);
                edition.addImage(image);
                editionRepository.save(edition);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveVideosToEdition(Long editionId, List<MultipartFile> multipartVideos) {
        Edition edition = editionRepository.findById(editionId).orElseThrow();

        try {
            for (MultipartFile multipartVideo : multipartVideos) {
//                String originalFilename = multipartVideo.getOriginalFilename();
//                fileSystemRepository.saveFile(multipartVideo.getBytes(), "edition", originalFilename);
                String videoPath = imageService.convertMultiPartToFile(multipartVideo, ImageType.EDITION);
//                FileUtils.saveFileToResources(multipartVideo.getBytes(), "edition", originalFilename);

                edition.addVideo(new EditionVideo(edition, videoPath));
                editionRepository.save(edition);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteMediaFromEdition(Long editionId, List<Long> imageIds, List<Long> videosIds) throws IOException, URISyntaxException {
        this.deleteImagesFromEdition(editionId, imageIds);
        this.deleteVideosFromEdition(editionId, videosIds);
    }

    public void deleteImagesFromEdition(Long editionId, List<Long> imageIds) throws IOException {
        Edition edition = editionRepository.findById(editionId).orElseThrow();

        for (Long imageId : imageIds) {
            EditionImage image = imageRepository.findById(imageId).orElseThrow();

            imageService.deleteImage(image.getPath());
//            FileUtils.deleteFile(image.getPath());

            edition.removeImage(image);
            editionRepository.save(edition);
        }
    }

    public void deleteImagesFromEdition(Long editionId) throws IOException {
        Edition edition = editionRepository.findById(editionId).orElseThrow();


//        for (EditionImage image : edition.getImages()) {
//            imageService.deleteImage(image.getPath());
//
//            edition.removeImage(image);
//            editionRepository.save(edition);
//        }
        for (Iterator<EditionImage> it = edition.getImages().iterator(); it.hasNext(); ) {
            it.remove();

            edition.removeImage(it.next());
            editionRepository.save(edition);
        }
    }

    public void deleteVideosFromEdition(Long editionId, List<Long> videosIds) throws IOException, URISyntaxException {
        Edition edition = editionRepository.findById(editionId).orElseThrow();

        for (Long videoId : videosIds) {
            EditionVideo video = videoRepository.findById(videoId).orElseThrow();

            imageService.deleteImage(video.getPath());
//            FileUtils.deleteFile(video.getPath());

            edition.removeVideo(video);
            editionRepository.save(edition);
        }
    }
}
