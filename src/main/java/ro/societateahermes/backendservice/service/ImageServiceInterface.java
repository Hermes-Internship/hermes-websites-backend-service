package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.exceptions.ImageException;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Image;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ImageServiceInterface {
    File convertMultiPartToFile(MultipartFile file) throws IOException;

    Image getImageByPath(String canonicalImagePath) throws ImageException;

    List<Image> getAll();
}
