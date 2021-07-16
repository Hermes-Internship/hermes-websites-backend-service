package ro.societateahermes.backendservice.service.serviceImplementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import ro.societateahermes.backendservice.exceptions.ImageException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Image;
import ro.societateahermes.backendservice.repository.ImageRepositoryInterface;
import ro.societateahermes.backendservice.service.ImageServiceInterface;

@Service
public class ImageServiceImplementation implements ImageServiceInterface {

    private final ImageRepositoryInterface imageRepository;

    public ImageServiceImplementation(ImageRepositoryInterface imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public File convertMultiPartToFile(MultipartFile file) throws IOException {
        UUID name = UUID.randomUUID();
        String imageName = name.toString();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        File convFile = new File("src/main/resources/images/" + imageName + "." + extension);
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        Image image = new Image();
        image.setCanonicalImagePath(convFile.getPath());
        imageRepository.save(image);
        return convFile;
    }

    @Override
    public Image getImageByPath(String canonicalImagePath) throws ImageException {
        for (Image image : getAll())
            if (image.getCanonicalImagePath().equals(canonicalImagePath))
                return image;
        throw new ImageException("There is no image with this path!");
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }
}